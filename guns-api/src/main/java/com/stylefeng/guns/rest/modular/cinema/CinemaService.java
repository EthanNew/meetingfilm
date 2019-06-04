package com.stylefeng.guns.rest.modular.cinema;

import com.stylefeng.guns.rest.model.cinema.bo.AreaBo;
import com.stylefeng.guns.rest.model.cinema.bo.BrandBo;
import com.stylefeng.guns.rest.model.cinema.bo.CinemaBo;
import com.stylefeng.guns.rest.model.cinema.bo.HallTypeBo;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestCinemasVo;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 17:02
 * @Description:
 */
public interface CinemaService {

    /**
     * 根据条件查询所有影院
     * @param requestCinemasVo
     * @return
     */
    List<CinemaBo> getPageCinemas(RequestCinemasVo requestCinemasVo);

    /**
     * 根据条件查询所有影院的总页数
     * @param requestCinemasVo
     * @return
     */
    int getTotalPage(RequestCinemasVo requestCinemasVo);

    /**
     * 获取影院列表查询条件之影院条件
     * @param brandId
     * @return
     */
    List<BrandBo> getBrandList(Integer brandId);

    /**
     * 获取影院列表查询条件之影厅条件
     * @param areaId
     * @return
     */
    List<AreaBo> getAreaList(Integer areaId);

    /**
     * 获取影院列表查询条件之行政区条件
     * @param hallType
     * @return
     */
    List<HallTypeBo> getHallTypeList(Integer hallType);
}
