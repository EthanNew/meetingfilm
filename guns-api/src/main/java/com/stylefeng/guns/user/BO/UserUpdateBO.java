package com.stylefeng.guns.user.BO;

import java.io.Serializable;
import java.util.Date;

public class UserUpdateBO implements Serializable {


    Integer UUID;
    //INT PRIMARY KEY AUTO_INCREMENT COMMENT '主键编号',
    String username;
    //VARCHAR(50) COMMENT '用户账号',
    String nickname;
    // VARCHAR(50) COMMENT '用户昵称',
    Integer sex ;
    // INT COMMENT '用户性别 0-男，1-女',
    Date birthday;
    // VARCHAR(50) COMMENT '出生日期',
    String email ;
    // VARCHAR(50) COMMENT '用户邮箱',
    String phone;
    // VARCHAR(50) COMMENT '用户手机号',
    String address ;
    // VARCHAR(50) COMMENT '用户住址',
    String headUrl;
    // VARCHAR(50) COMMENT '头像URL',
    String biography;
    // VARCHAR(200) COMMENT '个人介绍',
    Integer lifeState ;
    // INT COMMENT '生活状态 0-单身，1-热恋中，2-已婚，3-为人父母',
    Date beginTime ;
    //TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    Date updateTime ;
    //TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'


    public Integer getUUID() {
        return UUID;
    }

    public void setUUID(Integer UUID) {
        this.UUID = UUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getLifeState() {
        return lifeState;
    }

    public void setLifeState(Integer lifeState) {
        this.lifeState = lifeState;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
