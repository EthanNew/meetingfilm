package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeCinemaT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.model.cinema.bo.CinemaBO;
import com.stylefeng.guns.rest.model.cinema.bo.CinemaInfoBO;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestCinemasVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */

@Repository
public interface MtimeCinemaTMapper extends BaseMapper<MtimeCinemaT> {

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
     * 获取影院信息
     * @param cinemaId
     * @return
     */
    CinemaInfoBO getCinemaInfo(int cinemaId);
}
