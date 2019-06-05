package com.stylefeng.guns.rest.model.cinema.responsevo;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 19:26
 * @Description:
 */

public class ResponseExceptionVo {
    private Integer status;
    private String msg;

    public ResponseExceptionVo() {
    }

    public ResponseExceptionVo(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
