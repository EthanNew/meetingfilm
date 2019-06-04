package com.stylefeng.guns.rest.model.cinema.bo;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 20:46
 * @Description:
 */

public class CinemaBo {
    private Integer uuid;
    private String cinemaName;
    private String address;
    private Integer minimumPrice;

    public CinemaBo() {
    }

    public CinemaBo(Integer uuid, String cinemaName, String address, Integer minimumPrice) {
        this.uuid = uuid;
        this.cinemaName = cinemaName;
        this.address = address;
        this.minimumPrice = minimumPrice;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Integer minimumPrice) {
        this.minimumPrice = minimumPrice;
    }
}
