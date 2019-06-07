package com.stylefeng.guns.rest.modular.auth.controller.dto;

import com.stylefeng.guns.rest.modular.auth.validator.dto.Credence;

import javax.validation.constraints.NotEmpty;

/**
 * 认证的请求dto
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:00
 */
public class AuthRequest implements Credence {
    @NotEmpty
    private String userName;
    @NotEmpty
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getCredenceName() {
        return null;
    }

    @Override
    public String getCredenceCode() {
        return this.password;
    }
}
