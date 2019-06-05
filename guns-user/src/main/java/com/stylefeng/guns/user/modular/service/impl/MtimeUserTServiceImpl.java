package com.stylefeng.guns.user.modular.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.user.common.persistence.VO.MTimeUserVO;
import com.stylefeng.guns.user.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.user.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.user.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.user.modular.service.IMtimeUserTService;
import com.stylefeng.guns.user.modular.utiles.MD5Utils;
import com.stylefeng.guns.user.modular.utiles.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */
@Service
public class MtimeUserTServiceImpl extends ServiceImpl<MtimeUserTMapper, MtimeUserT> implements IMtimeUserTService {


    @Autowired
    MtimeUserTMapper mtimeUserTMapper;

    /**
     * 用户注册，对密码二次散列存储
     *
     * @param mTimeUserVO
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public Map insertMtimeUserVO(MTimeUserVO mTimeUserVO) {
        //先判断用户名是否已经存在
        MTimeUserVO mTimeUserVO1 = mtimeUserTMapper.checkUsername(mTimeUserVO.getUsername());
        if (mTimeUserVO1 != null) {
            return ResponseResult.responseResult("“用户已存在”", 1);
        }
        //用户名可用执行添加用户操作
        Date date = new Date();
        mTimeUserVO.setBeginTime(date);
        mTimeUserVO.setUpdateTime(date);
        //对密码二次散列存储
        String pwd = MD5Utils.getMd5(MD5Utils.getMd5(mTimeUserVO.getPassword()));
        if (pwd.length() > 0) {
            mTimeUserVO.setPassword(pwd);
            mtimeUserTMapper.insertMtimeUserVO(mTimeUserVO);
            return ResponseResult.responseResult("注册成功", 0);
        }
        return ResponseResult.responseResult("系统出现异常，请联系管理员", 999);
    }

    /**
     * 用户名是否可用检查
     *
     * @param username
     * @return
     */
    @Override
    public Map checkUsername(String username) {
        MTimeUserVO mTimeUserVO = mtimeUserTMapper.checkUsername(username);
        if (mTimeUserVO != null) {
            return ResponseResult.responseResult("“用户已存在”", 1);
        } else {
            return ResponseResult.responseResult("“验证成功””", 0);
        }
    }

    /**
     * 用户登录，对密码二次散列后与数据库 比对
     *
     * @param authRequest
     * @return ture 数据库存在该用户，false 该用户不存在
     */
    @Override
    public boolean login(AuthRequest authRequest) {
        String pwd = MD5Utils.getMd5(MD5Utils.getMd5(authRequest.getPassword()));
        authRequest.setPassword(pwd);
        return mtimeUserTMapper.login(authRequest) != null;
    }

    @Override
    public Map getUserInfo(String username) {
        MTimeUserVO mTimeUserVO = mtimeUserTMapper.checkUsername(username);
        Map map = new HashMap<>();
        map.put("data", mTimeUserVO);
        map.put("status", 0);
        return map;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.REPEATABLE_READ)
    public Map updateUserInfo(MTimeUserVO mTimeUserVO) {
        if(mTimeUserVO != null && mTimeUserVO.getUUID() != null) {
            mTimeUserVO.setUpdateTime(new Date());
            int i = mtimeUserTMapper.updateUserInfo(mTimeUserVO);
            if (i == 1) {
                Map map = new HashMap();
                map.put("data", mtimeUserTMapper.selectMTimeUserVOById(mTimeUserVO.getUUID()));
                map.put("status", 0);
                return map;
            }
        }
        return ResponseResult.responseResult("用户信息修改失败",1);
    }
}
