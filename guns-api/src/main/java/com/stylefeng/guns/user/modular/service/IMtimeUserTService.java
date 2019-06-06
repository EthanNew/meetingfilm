package com.stylefeng.guns.user.modular.service;


import com.stylefeng.guns.user.BO.UserInfoBO;
import com.stylefeng.guns.user.VO.UserRegistVO;
import com.stylefeng.guns.user.VO.UserUpdateVO;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */

public interface IMtimeUserTService {

    int insertMtimeUser(UserRegistVO userRegistVO);

    int checkUsername(String username);

    boolean login(String username,String password);

    UserInfoBO getUserInfoByName(String username);

    UserInfoBO updateUserInfo(UserUpdateVO userUpdateVO);

}
