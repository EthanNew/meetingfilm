package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeAreaDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.model.cinema.bo.AreaBO;
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
public interface MtimeAreaDictTMapper extends BaseMapper<MtimeAreaDictT> {

    /**
     * 获取影院列表查询条件之影厅条件
     * @param areaId
     * @return
     */
    List<AreaBO> getAreaList(@Param("areaId") int areaId);
}
