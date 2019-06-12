package com.stylefeng.guns.rest.model.order.orderResVo;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZhangYao
 * Date 2019/4/25 Time 15:24
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo implements Serializable {
    private String orderId;
    private String filmName;
    private String fieldTime;
    private String cinemaName;
    private String seatsName;
    private String orderPrice;
    private String orderTimestamp;
    private String orderStatus;

    public String getOrderStatus() {
        if ("0".equals(orderStatus)) {
            orderStatus = "待支付";
        } else if ("1".equals(orderStatus)) {
            orderStatus = "已支付";
        } else if ("2".equals(orderStatus)) {
            orderStatus = "已关闭";
        } else {
            return "未知状态";
        }
        return orderStatus;
    }
}
