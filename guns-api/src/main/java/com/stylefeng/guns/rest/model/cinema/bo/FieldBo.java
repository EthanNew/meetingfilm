package com.stylefeng.guns.rest.model.cinema.bo;

/**
 * @Author: Ethan New
 * @Date: 2019/6/5 18:01
 * @Description:
 */

public class FieldBo {
    private Integer fieldId;
    private String beginTime;
    private String endTime;
    private String language;
    private String hallName;
    private Integer price;

    public FieldBo() {
    }

    public FieldBo(Integer fieldId, String beginTime, String endTime, String language, String hallName, Integer price) {
        this.fieldId = fieldId;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.language = language;
        this.hallName = hallName;
        this.price = price;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
