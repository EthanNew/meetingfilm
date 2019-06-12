package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.orderApi.OrderApi;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.model.order.orderResVo.BuyTicketsResVo;
import com.stylefeng.guns.rest.model.order.orderResVo.OrderInfoVo;
import com.stylefeng.guns.rest.model.order.orderResVo.OrderVo;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ZhangYao
 * Date 2019/4/25 Time 18:36
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference
    OrderApi orderApi;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    JwtProperties jwtProperties;

    @RequestMapping(value = "/buyTickets", method = RequestMethod.POST)
    public BuyTicketsResVo buyTickets(@RequestParam("fieldId") String fieldId,
                                      @RequestParam("soldSeats") String soldSeats,
                                      @RequestParam("seatsName") String seatsName){
        BuyTicketsResVo buyTicketsResVo = new BuyTicketsResVo();
        try {
            boolean areSeatsExsit = orderApi.isTrueSeats(fieldId, soldSeats);
            boolean areSeatsNotSold = orderApi.isNotSoldSeats(fieldId, soldSeats);
            if (!areSeatsExsit){
                buyTicketsResVo.setStatus(1);
                buyTicketsResVo.setMsg("不存在的座位");
                return buyTicketsResVo;
            }
            if (!areSeatsNotSold){
                buyTicketsResVo.setStatus(1);
                buyTicketsResVo.setMsg("座位已售出");
                return buyTicketsResVo;
            }

            OrderVo orderVo = orderApi.saveOrderInfo(Integer.parseInt(fieldId), soldSeats, seatsName, 1);
            buyTicketsResVo.setData(orderVo);
        }catch (Exception e){
            e.printStackTrace();
            buyTicketsResVo.setStatus(999);
            buyTicketsResVo.setMsg("系统错误，请联系管理员");
            return buyTicketsResVo;
        }
        buyTicketsResVo.setStatus(0);
        return buyTicketsResVo;
    }

    @RequestMapping(value = "/getOrderInfo", method = RequestMethod.POST)
    public OrderInfoVo getOrderInfo(@RequestParam(name = "nowPage", defaultValue = "1") Integer nowPage,
                                    @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize){
        OrderInfoVo orderInfoVo = new OrderInfoVo();
        //ToDo 从token里拿用户Id 此处写死
        try {
            Page<OrderVo> page = new Page<>();
            page.setSize(pageSize);
            page.setCurrent(nowPage);
            Page<OrderVo> orderByUserId = orderApi.getOrderByUserId(page, 1);
            if (orderByUserId.getRecords().size() == 0){
                orderInfoVo.setStatus(1);
                orderInfoVo.setMsg("订单列表为空哦");
                return orderInfoVo;
            }
            orderInfoVo.setData(orderByUserId.getRecords());
        } catch (Exception e){
            e.printStackTrace();
            orderInfoVo.setStatus(999);
            orderInfoVo.setMsg("系统错误请联系管理员");
            return orderInfoVo;
        }
        orderInfoVo.setStatus(0);
        return orderInfoVo;
    }
}
