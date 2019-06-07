package com.stylefeng.guns.rest.model.cinema.bo;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:59
 * @Description:
 */

public class HallBO implements Serializable {
     private int hallId;
     private String showName;
     private String seatAddress;
     private boolean isActive;

    @Override
    public String toString() {
        return "HallBO{" +
                "hallId=" + hallId +
                ", showName='" + showName + '\'' +
                ", seatAddress='" + seatAddress + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getSeatAddress() {
        return seatAddress;
    }

    public void setSeatAddress(String seatAddress) {
        this.seatAddress = seatAddress;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
