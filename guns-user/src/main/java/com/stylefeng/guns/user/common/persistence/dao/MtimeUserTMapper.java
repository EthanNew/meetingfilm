package com.stylefeng.guns.user.common.persistence.dao;

import com.stylefeng.guns.user.BO.UserInfoBO;
import com.stylefeng.guns.user.VO.UserRegistVO;
import com.stylefeng.guns.user.VO.UserUpdateVO;
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

    int checkUsername(@Param("username") String username);

    int insertMtimeUser(@Param("user") UserRegistVO userRegistVO);

    UserInfoBO getUserInfoByName(@Param("username") String username);

    int login(@Param("username") String username,@Param("password") String password);

    int updateUserInfo(@Param("user") UserUpdateVO userUpdateVO);

    UserInfoBO getUserInfoById(@Param("uuid") Integer uuid);
}
