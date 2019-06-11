package com.stylefeng.guns.rest.modular.cinema;

import com.stylefeng.guns.rest.model.cinema.bo.*;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestCinemasVO;

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
    List<CinemaBO> getPageCinemas(RequestCinemasVO requestCinemasVo);

    /**
     * 根据条件查询所有影院的总页数
     * @param requestCinemasVo
     * @return
     */
    int getTotalPage(RequestCinemasVO requestCinemasVo);

    /**
     * 获取影院列表查询条件之影院条件
     * @param brandId
     * @return
     */
    List<BrandBO> getBrandList(int brandId);

    /**
     * 获取影院列表查询条件之影厅条件
     * @param areaId
     * @return
     */
    List<AreaBO> getAreaList(int areaId);

    /**
     * 获取影院列表查询条件之行政区条件
     * @param hallType
     * @return
     */
    List<HallTypeBO> getHallTypeList(int hallType);

    /**
     * 获取影院信息
     * @param cinemaId
     * @return
     */
    CinemaInfoBO getCinemaInfo(int cinemaId);

    HallInfoBO getHallInfo(int fieldId);
}
