package com.stylefeng.guns.user.modular.controller;

import com.stylefeng.guns.user.common.persistence.VO.MTimeUserVO;
import com.stylefeng.guns.user.config.properties.JwtProperties;
import com.stylefeng.guns.user.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.user.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.user.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.user.modular.service.IMtimeUserTService;
import com.stylefeng.guns.user.modular.utiles.ResponseResult;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

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

    @Autowired
    IMtimeUserTService MtimeUserTService;

    @PostMapping("/user/register")
    public Map register(@RequestBody MTimeUserVO mTimeUserVO) {
        return MtimeUserTService.insertMtimeUserVO(mTimeUserVO);
    }

    @PostMapping("/user/check")
    public Map checkUsername(@RequestBody @NotNull String username) {
        return MtimeUserTService.checkUsername(username);
    }

    @GetMapping("/user/getUserInfo")
    public Map getUserInfo(HttpServletRequest request) {
        String header = request.getHeader(jwtProperties.getHeader());
        //访问此接口时先经过filter，保证了header不空且以Bearer 开头
        String authToken = header.substring(7);
        Claims claimFromToken = jwtTokenUtil.getClaimFromToken(authToken);
        return MtimeUserTService.getUserInfo(claimFromToken.getSubject());
    }

    @PostMapping("/user/updateUserInfo")
    public Map updateUserInfo(@RequestBody MTimeUserVO mTimeUserVO ) {

        return MtimeUserTService.updateUserInfo(mTimeUserVO);
    }

    @GetMapping("/user/logout")
    public Map logout(HttpServletRequest request) {
        String header = request.getHeader(jwtProperties.getHeader());
        //访问此接口时先经过filter，保证了header不空且以Bearer 开头
        String authToken = header.substring(7);
        Claims claimFromToken = jwtTokenUtil.getClaimFromToken(authToken);
        System.out.println(claimFromToken.getSubject());
        return ResponseResult.responseResult("退出成功", 0);
    }

    @PostMapping("/auth")
    public Map createAuthenticationToken(@RequestBody AuthRequest authRequest) {
        boolean validate = MtimeUserTService.login(authRequest);
        Map map = new HashMap();
        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            map.put("data",new AuthResponse(token, randomKey));
            map.put("status",0);
            return map;
        }
        else {
            return ResponseResult.responseResult("用户名或密码错误",1);
        }
    }
}

