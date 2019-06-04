package com.stylefeng.guns.rest.model.cinema.requestvo;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:25
 * @Description:
 */

public class RequestConditionVo implements Serializable {
    private Integer brandId;
    private Integer hallType;
    private Integer areaId;

    public RequestConditionVo() {
    }

    public RequestConditionVo(Integer brandId, Integer hallType, Integer areaId) {
        this.brandId = brandId;
        this.hallType = hallType;
        this.areaId = areaId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getHallType() {
        return hallType;
    }

    public void setHallType(Integer hallType) {
        this.hallType = hallType;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
