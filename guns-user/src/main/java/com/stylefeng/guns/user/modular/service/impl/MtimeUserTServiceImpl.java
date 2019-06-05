package com.stylefeng.guns.user.modular.service.impl;

import com.stylefeng.guns.user.common.persistence.VO.MTimeUserVO;
import com.stylefeng.guns.user.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.user.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.user.modular.service.IMtimeUserTService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.stylefeng.guns.user.modular.utiles.MD5Utils;
import com.stylefeng.guns.user.modular.utiles.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    private Logger logger = Logger.getLogger(getClass()) ;

    @Autowired
    MtimeUserTMapper mtimeUserTMapper;

    @Override
    public Map insertMtimeUserVO(MTimeUserVO mTimeUserVO) {
        Date date = new Date();
        mTimeUserVO.setBeginTime(date);
        mTimeUserVO.setUpdateTime(date);
        //利用用户电话号码对用户密码进行加盐散列 后再次散列，得到的二次散列值
        String pwd = MD5Utils.getMd5(MD5Utils.getMd5(mTimeUserVO.getPassword(), mTimeUserVO.getPhone()));
        if (pwd.length() > 0) {
            mTimeUserVO.setPassword(pwd);
                int i = mtimeUserTMapper.insertMtimeUserVO(mTimeUserVO);
                return i == 1? ResponseResult.responseResult("注册成功", 0)
                        : ResponseResult.responseResult("“用户已存在”", 1);
        }
        return ResponseResult.responseResult("系统出现异常，请联系管理员", 999);
    }

    @Override
    public Map checkUsername(String username) {
         MtimeUserT mtimeUserT = mtimeUserTMapper.checkUsername(username);
         if (mtimeUserT != null){
             return ResponseResult.responseResult("“用户已存在”", 1);
         }
         else {
             return ResponseResult.responseResult("“验证成功””", 0);
         }
    }
}
