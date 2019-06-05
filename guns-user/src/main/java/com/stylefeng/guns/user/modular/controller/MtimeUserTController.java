package com.stylefeng.guns.user.modular.controller;


import com.stylefeng.guns.user.common.persistence.VO.MTimeUserVO;
import com.stylefeng.guns.user.modular.service.IMtimeUserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */
@Controller
@RequestMapping("/user")
public class MtimeUserTController {

    @Autowired
    IMtimeUserTService MtimeUserTService;

    @PostMapping("/register")
    public Map register(@RequestBody MTimeUserVO mTimeUserVO) {
        return MtimeUserTService.insertMtimeUserVO(mTimeUserVO);
    }

    @PostMapping("/check")
    public Map checkUsername(@RequestBody @NotNull String username) {
        return MtimeUserTService.checkUsername(username);
    }


}

