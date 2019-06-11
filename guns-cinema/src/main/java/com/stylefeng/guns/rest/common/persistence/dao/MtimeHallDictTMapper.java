package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeHallDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.model.cinema.bo.HallInfoBO;
import com.stylefeng.guns.rest.model.cinema.bo.HallTypeBO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */

@Repository
public interface MtimeHallDictTMapper extends BaseMapper<MtimeHallDictT> {

    /**
     * 获取影院列表查询条件之行政区条件
     * @param hallType
     * @return
     */
    List<HallTypeBO> getHallTypeList(@Param("hallType") int hallType);

    /**
     *
     * @param fieldId
     * @return
     */
    HallInfoBO getHallInfo(@Param("fieldId") int fieldId);
}
