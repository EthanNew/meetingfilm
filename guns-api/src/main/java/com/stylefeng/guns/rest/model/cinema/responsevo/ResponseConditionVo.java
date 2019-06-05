package com.stylefeng.guns.rest.model.cinema.responsevo;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:08
 * @Description:
 */

public class ResponseConditionVo<T> {
    private Integer status;

    private T data;

    public ResponseConditionVo() {
    }

    public ResponseConditionVo(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
