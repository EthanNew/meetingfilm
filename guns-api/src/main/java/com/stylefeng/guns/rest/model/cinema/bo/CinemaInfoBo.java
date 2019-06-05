package com.stylefeng.guns.rest.model.cinema.bo;

/**
 * @Author: Ethan New
 * @Date: 2019/6/5 17:25
 * @Description:
 */

public class CinemaInfoBo {
    private Integer cinemaId;
    private String cinemaName;
    private String cinemaPhone;
    private String imgUrl;
    private String cinemaAdress;

    public CinemaInfoBo() {
    }

    public CinemaInfoBo(Integer cinemaId, String cinemaName, String cinemaPhone, String imgUrl, String cinemaAdress) {
        this.cinemaId = cinemaId;
        this.cinemaName = cinemaName;
        this.cinemaPhone = cinemaPhone;
        this.imgUrl = imgUrl;
        this.cinemaAdress = cinemaAdress;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCinemaAdress() {
        return cinemaAdress;
    }

    public void setCinemaAdress(String cinemaAdress) {
        this.cinemaAdress = cinemaAdress;
    }
}
