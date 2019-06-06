package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.config.properties.JwtProperties;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.user.BO.UserInfoBO;
import com.stylefeng.guns.user.VO.UserRegistVO;
import com.stylefeng.guns.user.VO.UserUpdateVO;
import com.stylefeng.guns.user.modular.service.IMtimeUserTService;
import com.stylefeng.guns.user.utiles.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author EthanNew
 * @since 2019-06-04
 */
@RestController
public class MtimeUserTController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    @Reference
    IMtimeUserTService MtimeUserTService;

    @Autowired
    ResponseResult result;

    @PostMapping("/user/register")
    public ResponseResult register(@RequestBody @Valid UserRegistVO userRegistVO) {
        int i = MtimeUserTService.insertMtimeUser(userRegistVO);
        if (i == 1) return result.responseResult("用户已经存在", 1);
        if (i == 0) return result.responseResult("注册成功", 0);
        return result.responseResult("系统出现异常，请联系管理员", 999);
    }

    @PostMapping("/user/check")
    public ResponseResult checkUsername(@RequestBody @NotNull String username) {
        int i = MtimeUserTService.checkUsername(username);
        if (i == 1) return result.responseResult("用户已经存在", 1);
        if (i == 0) return result.responseResult("验证成功", 0);
        return result.responseResult("系统出现异常，请联系管理员", 999);
    }

    @GetMapping("/user/getUserInfo")
    public ResponseResult getUserInfoByName(HttpServletRequest request) {
        String header = request.getHeader(jwtProperties.getHeader());
        //访问此接口时先经过filter，保证了header不空且以Bearer 开头
        String authToken = header.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        UserInfoBO userInfo = MtimeUserTService.getUserInfoByName(username);
        if (userInfo != null) {
            return result.responseResult("", 0, userInfo);
        }
        return result.responseResult("查询失败，用户尚未登录", 1);
    }

    @PostMapping("/user/updateUserInfo")
    public ResponseResult updateUserInfo(@RequestBody @Valid UserUpdateVO userUpdateVO) {

        UserInfoBO userInfo = MtimeUserTService.updateUserInfo(userUpdateVO);
        if (userInfo != null) {
            return result.responseResult("", 0, userInfo);
        }
        return result.responseResult("用户信息修改失败", 1);
    }

    @GetMapping("/user/logout")
    public ResponseResult logout(HttpServletRequest request) {
        String header = request.getHeader(jwtProperties.getHeader());
        //访问此接口时先经过filter，保证了header不空且以Bearer 开头
        String authToken = header.substring(7);
        return result.responseResult("退出成功", 0);
    }

    @PostMapping("/auth")
    public ResponseResult userLogin(@RequestBody @Valid AuthRequest authRequest) {
        boolean validate = MtimeUserTService.login(authRequest.getUsername(),authRequest.getPassword());
        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getCredenceName(), randomKey);

            return result.responseResult("", 0, new AuthResponse(token, randomKey));
        }
        return result.responseResult("用户名或密码错误", 1);
    }
}

