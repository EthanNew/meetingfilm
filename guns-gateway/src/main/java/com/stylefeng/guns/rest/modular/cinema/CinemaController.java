package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.orderApi.OrderApi;
import com.stylefeng.guns.rest.model.cinema.bo.*;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestCinemasVO;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestConditionVO;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseCinemasVO;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseConditionVO;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseExceptionVO;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseFilmsVO;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 16:44
 * @Description:
 */

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Reference
    CinemaService cinemaService;

    @Reference
    FilmServiceApi filmService;

    @Reference
    OrderApi orderService;

    /**
     * 根据条件查询所有影院
     * @param requestCinemasVo
     */
    @GetMapping("/getCinemas")
    public Object getCinemas(RequestCinemasVO requestCinemasVo) {
        try {
            List<CinemaBO> list = cinemaService.getPageCinemas(requestCinemasVo);
            int totalPage = cinemaService.getTotalPage(requestCinemasVo);
            ResponseCinemasVO<List<CinemaBO>> listResponseCinemasVo = new ResponseCinemasVO<>(0, requestCinemasVo.getNowPage(), totalPage, list);
            return listResponseCinemasVo;
        } catch (Exception e) {
            ResponseExceptionVO responseExceptionVo = new ResponseExceptionVO(1, "影院信息查询失败");
            e.printStackTrace();
            return responseExceptionVo;
        }
    }

    /**
     * 获取影院列表查询条件
     * @param requestConditionVo
     * @return
     */
    @GetMapping("/getCondition")
    public Object getCondition(RequestConditionVO requestConditionVo) {
        try {
            List<BrandBO> brandList = cinemaService.getBrandList(requestConditionVo.getBrandId());
            List<AreaBO> areaList = cinemaService.getAreaList(requestConditionVo.getAreaId());
            List<HallTypeBO> halltypeList = cinemaService.getHallTypeList(requestConditionVo.getHallType());
            Map<String, Object> map = new HashMap<>(16);
            map.put("brandList", brandList);
            map.put("areaList", areaList);
            map.put("halltypeList", halltypeList);
            ResponseConditionVO<Map<String, Object>> responseConditionVo = new ResponseConditionVO<>(0, map);
            return responseConditionVo;
        } catch (Exception e) {
            ResponseExceptionVO responseExceptionVo = new ResponseExceptionVO(1, "影院信息查询失败");
            e.printStackTrace();
            return responseExceptionVo;
        }
    }

    /**
     * 获取播放场次
     * @param cinemaId
     * @return
     */
    @RequestMapping(value = "/getFields", method = {RequestMethod.GET, RequestMethod.POST})
    public Object getFields(@RequestParam("cinemaId") int cinemaId) {
        try {
            CinemaInfoBO cinemaInfoBo = cinemaService.getCinemaInfo(cinemaId);
            List<FilmBO> filmBos = filmService.getFilmList();
            String imgPre = "http://img.meetingshop.cn/";
            Map<String, Object> map = new HashMap<>(16);
            map.put("cinemaInfo", cinemaInfoBo);
            map.put("filmList", filmBos);
            ResponseFilmsVO<Map<String, Object>> mapResponseFilmsVo = new ResponseFilmsVO<>(0, imgPre, map);
            return mapResponseFilmsVo;
        } catch (Exception e) {
            ResponseExceptionVO responseExceptionVo = new ResponseExceptionVO(1, "影院信息查询失败");
            e.printStackTrace();
            return responseExceptionVo;
        }
    }
    /**
     *  根据放映场次ID(fieldId)获取放映信息
     * @param fieldId
     * @return
     */
    @RequestMapping("/getFieldInfo")
    public Object getFieldInfo(@RequestParam(value = "fieldId", defaultValue = "99") int fieldId,
                               @RequestParam(value = "cinemaId", defaultValue = "99") int cinemaId){
        try {
             CinemaInfoBO cinemaInfoBo = cinemaService.getCinemaInfo(cinemaId);
             FilmInfoBO filmInfoBO = filmService.getFilmByFieldId(fieldId);
             HallInfoBO hallInfoBO = cinemaService.getHallInfo(fieldId);
             String soldSeats = orderService.getSoldSeatsByFieldId(fieldId);
             hallInfoBO.setSoldSeats(soldSeats);
             String imgPre = "http://img.meetingshop.cn/";
             Map<String, Object> map = new HashMap<>(16);
             map.put("cinemaInfo", cinemaInfoBo);
             map.put("filmInfo", filmInfoBO);
             map.put("hallInfo", hallInfoBO);
             ResponseFilmsVO<Map<String, Object>> mapResponseFilmsVo = new ResponseFilmsVO<>(0, imgPre, map);
             return mapResponseFilmsVo;
        } catch (Exception e) {
            ResponseExceptionVO responseExceptionVo = new ResponseExceptionVO(1, "影院信息查询失败");
            e.printStackTrace();
            return responseExceptionVo;
        }
    }
}
