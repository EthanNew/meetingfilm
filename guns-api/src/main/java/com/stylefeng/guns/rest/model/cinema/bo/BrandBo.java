package com.stylefeng.guns.rest.model.cinema.bo;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:56
 * @Description:
 */

public class BrandBo implements Serializable {
    private Integer brandId;
    private String brandName;
    private boolean isActive;

    public BrandBo() {
    }

    public BrandBo(Integer brandId, String brandName, boolean isActive) {
        this.brandId = brandId;
        this.brandName = brandName;
        this.isActive = isActive;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
