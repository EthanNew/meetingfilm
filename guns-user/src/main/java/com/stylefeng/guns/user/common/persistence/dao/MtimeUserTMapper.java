package com.stylefeng.guns.user.common.persistence.dao;

import com.stylefeng.guns.user.common.persistence.VO.MTimeUserVO;
import com.stylefeng.guns.user.common.persistence.model.MtimeUserT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {

    MtimeUserT checkUsername(@Param("username") String username);

    int insertMtimeUserVO(@Param("user") MTimeUserVO mTimeUserVO);
}
