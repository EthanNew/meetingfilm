package com.stylefeng.guns.rest.model.cinema.requestvo;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 19:29
 * @Description:
 */

public class RequestCinemasVo implements Serializable {
    private Integer brandId = 99;
    private Integer hallType = 99;
    private Integer districtId = 99;
    private Integer pageSize = 12;
    private Integer nowPage = 1;

    public RequestCinemasVo() {
    }

    public RequestCinemasVo(Integer brandId, Integer hallType, Integer districtId, Integer pageSize, Integer nowPage) {
        this.brandId = brandId;
        this.hallType = hallType;
        this.districtId = districtId;
        this.pageSize = pageSize;
        this.nowPage = nowPage;
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

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }
}
