package com.stylefeng.guns.user.VO;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class UserRegistVO implements Serializable {
    @NotBlank
    String username;
    //VARCHAR(50) COMMENT '用户账号',
    @Length(min = 6,max = 20,message = "密码长度为6-20位字符")
    String password;
    // VARCHAR(50) COMMENT '用户密码',
    String email ;
    // VARCHAR(50) COMMENT '用户邮箱',
    String phone;
    // VARCHAR(50) COMMENT '用户手机号',
    String address ;
    // VARCHAR(50) COMMENT '用户住址',


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
