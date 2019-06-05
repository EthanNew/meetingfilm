package com.stylefeng.guns.rest.model.cinema.bo;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:57
 * @Description:
 */

public class AreaBo implements Serializable {
    private Integer areaId;
    private String areaName;
    private boolean isActive;

    public AreaBo() {
    }

    public AreaBo(Integer areaId, String areaName, boolean isActive) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.isActive = isActive;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
