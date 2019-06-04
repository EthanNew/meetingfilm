package com.stylefeng.guns.rest.model.cinema.bo;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:59
 * @Description:
 */

public class HallTypeBo implements Serializable {
    private Integer halltypeId;
    private String halltypeName;
    private boolean isActive;

    public HallTypeBo() {
    }

    public HallTypeBo(Integer halltypeId, String halltypeName, boolean isActive) {
        this.halltypeId = halltypeId;
        this.halltypeName = halltypeName;
        this.isActive = isActive;
    }

    public Integer getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(Integer halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
