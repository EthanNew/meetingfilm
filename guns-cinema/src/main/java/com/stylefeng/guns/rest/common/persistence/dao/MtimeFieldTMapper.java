package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimeFieldT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.model.cinema.bo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */
@Repository
public interface MtimeFieldTMapper extends BaseMapper<MtimeFieldT> {
    /**
     * 根据放映场次ID(fieldId)获取放映信息
     * @param  fieldId
     * @return
     */
      FieldBO getFieldByfieldId(@Param("fieldId") int fieldId);
    /**
     *  根据放映场次查询播放的电影编号，然后根据电影编号获取对应的电影信息
     * @param  fieldId
     * @return
     */
      FilmInfoBO getFilmByfieId(@Param("fieldId") int fieldId);

    /**
     *    根据放映场次ID获取已售座位
     * @param  fieldId
     * @return
     */
      /*HallBO  getHallByfieId(int fieldId);*/
}
