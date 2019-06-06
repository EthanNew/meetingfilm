package com.stylefeng.guns.user.modular.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.user.BO.UserInfoBO;
import com.stylefeng.guns.user.VO.UserRegistVO;
import com.stylefeng.guns.user.VO.UserUpdateVO;
import com.stylefeng.guns.user.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.user.modular.service.IMtimeUserTService;
import com.stylefeng.guns.user.utiles.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */
@Service(interfaceClass = IMtimeUserTService.class)
@Component
public class MtimeUserTServiceImpl implements IMtimeUserTService {


    @Autowired
    MtimeUserTMapper mtimeUserTMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public int insertMtimeUser(UserRegistVO userRegistVO) {
        //先判断用户名是否已经存在
        if (1 == mtimeUserTMapper.checkUsername(userRegistVO.getUsername())) return 1;

        //对密码二次散列存储
        String pwd = MD5Utils.getMd5(MD5Utils.getMd5(userRegistVO.getPassword()));
        if (pwd.length() > 0) {
            userRegistVO.setPassword(pwd);
            mtimeUserTMapper.insertMtimeUser(userRegistVO);
            return 0;
        }
        return 999;
    }

    /**
     * 用户名是否可用检查
     * @param username
     * @return 返回值1 表示用户名已经存在，返回0表示用户名不存在
     */
    @Override
    public int checkUsername(String username) {
        return mtimeUserTMapper.checkUsername(username) == 1 ? 1 : 0;
    }

    @Override
    public boolean login(String username,String password) {
        String pwd = MD5Utils.getMd5(MD5Utils.getMd5(password));
        return mtimeUserTMapper.login(username,pwd) == 1;
    }

    @Override
    public UserInfoBO getUserInfoByName(String username) {
       return mtimeUserTMapper.getUserInfoByName(username);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.REPEATABLE_READ)
    public UserInfoBO updateUserInfo(UserUpdateVO userUpdateVO) {
        if(userUpdateVO != null && userUpdateVO.getUUID() != null) {
            if (1 == mtimeUserTMapper.updateUserInfo(userUpdateVO)) {
             return mtimeUserTMapper.getUserInfoById(userUpdateVO.getUUID());
            }
        }
        return null;
    }
}
