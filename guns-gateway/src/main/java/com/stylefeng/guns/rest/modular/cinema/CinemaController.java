package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.rest.model.cinema.bo.*;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestCinemasVo;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestConditionVo;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseCinemasVo;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseConditionVo;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseExceptionVo;
import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseFilmsVo;
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

    /**
     * 根据条件查询所有影院
     * @param requestCinemasVo
     */
    @GetMapping("/getCinemas")
    public Object getCinemas(RequestCinemasVo requestCinemasVo) {
        try {
            List<CinemaBo> list = cinemaService.getPageCinemas(requestCinemasVo);
            int totalPage = cinemaService.getTotalPage(requestCinemasVo);
            ResponseCinemasVo<List<CinemaBo>> listResponseCinemasVo = new ResponseCinemasVo<>(0, requestCinemasVo.getNowPage(), totalPage, list);
            return listResponseCinemasVo;
        } catch (Exception e) {
            ResponseExceptionVo responseExceptionVo = new ResponseExceptionVo(1, "影院信息查询失败");
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
    public Object getCondition(RequestConditionVo requestConditionVo) {
        try {
            List<BrandBo> brandList = cinemaService.getBrandList(requestConditionVo.getBrandId());
            List<AreaBo> areaList = cinemaService.getAreaList(requestConditionVo.getAreaId());
            List<HallTypeBo> halltypeList = cinemaService.getHallTypeList(requestConditionVo.getHallType());
            Map<String, Object> map = new HashMap<>(16);
            map.put("brandList", brandList);
            map.put("areaList", areaList);
            map.put("halltypeList", halltypeList);
            ResponseConditionVo<Map<String, Object>> responseConditionVo = new ResponseConditionVo<>(0, map);
            return responseConditionVo;
        } catch (Exception e) {
            ResponseExceptionVo responseExceptionVo = new ResponseExceptionVo(1, "影院信息查询失败");
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
    public Object getFields(int cinemaId) {
        try {
            CinemaInfoBo cinemaInfoBo = cinemaService.getCinemaInfo(cinemaId);
            List<FilmBo> filmBos = filmService.getFilmList();
            String imgPre = cinemaInfoBo.getImgUrl();
            Map<String, Object> map = new HashMap<>(16);
            map.put("cinemaInfo", cinemaInfoBo);
            map.put("filmList", filmBos);
            ResponseFilmsVo<Map<String, Object>> mapResponseFilmsVo = new ResponseFilmsVo<>(0, imgPre, map);
            return mapResponseFilmsVo;
        } catch (Exception e) {
            ResponseExceptionVo responseExceptionVo = new ResponseExceptionVo(1, "影院信息查询失败");
            e.printStackTrace();
            return responseExceptionVo;
        }
    }
    /**
     *  根据放映场次ID(fieldId)获取放映信息
     * @param fieldId
     * @return
     */
    @PostMapping("/getFieldInfo")
    public Object getFieldInfo(int fieldId, int cinemaId){
        /*FieldBo fieldByfieldId = cinemaService.getFieldByfieldId(fieldId);
        return null;*/
        try {
             CinemaInfoBo cinemaInfoBo = cinemaService.getCinemaInfo(cinemaId);
             FilmInfoBo filmByfieldId = cinemaService.getFilmByfieldId(fieldId);
             List<FilmBo> filmBos = filmService.getFilmList();
             String imgPre = cinemaInfoBo.getImgUrl();
             Map<String, Object> map = new HashMap<>(16);
             map.put("cinemaInfo", cinemaInfoBo);
             map.put("filmList", filmByfieldId );
             ResponseFilmsVo<Map<String, Object>> mapResponseFilmsVo = new ResponseFilmsVo<>(0, imgPre, map);
             return mapResponseFilmsVo;
        } catch (Exception e) {
            ResponseExceptionVo responseExceptionVo = new ResponseExceptionVo(1, "影院信息查询失败");
            e.printStackTrace();
            return responseExceptionVo;
        }
    }
}
