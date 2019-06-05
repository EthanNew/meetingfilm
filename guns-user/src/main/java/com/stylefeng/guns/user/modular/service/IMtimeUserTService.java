package com.stylefeng.guns.user.modular.service;

import com.stylefeng.guns.user.common.persistence.VO.MTimeUserVO;
import com.stylefeng.guns.user.common.persistence.model.MtimeUserT;
import com.baomidou.mybatisplus.service.IService;

import java.util.Map;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */
public interface IMtimeUserTService extends IService<MtimeUserT> {

    Map insertMtimeUserVO(MTimeUserVO mTimeUserVO);

    Map checkUsername(String username);
}
