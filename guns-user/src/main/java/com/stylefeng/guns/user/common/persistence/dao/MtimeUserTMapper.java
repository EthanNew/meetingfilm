package com.stylefeng.guns.user.common.persistence.dao;

import com.stylefeng.guns.user.common.persistence.VO.MTimeUserVO;
import com.stylefeng.guns.user.common.persistence.model.MtimeUserT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.user.modular.auth.controller.dto.AuthRequest;
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

    MTimeUserVO checkUsername(@Param("username") String username);

    int insertMtimeUserVO(@Param("user") MTimeUserVO mTimeUserVO);

    MTimeUserVO login(@Param("authRequest") AuthRequest authRequest);

    int updateUserInfo(@Param("user") MTimeUserVO mTimeUserVO);

    MTimeUserVO selectMTimeUserVOById(@Param("uuid") Integer uuid);
}
