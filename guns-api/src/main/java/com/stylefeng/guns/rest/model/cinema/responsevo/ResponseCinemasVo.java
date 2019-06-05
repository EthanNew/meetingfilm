package com.stylefeng.guns.rest.model.cinema.responsevo;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:08
 * @Description:
 */

public class ResponseCinemasVo<T> {
    private Integer status;
    private Integer nowPage;
    private Integer totalPage;
    private T data;

    public ResponseCinemasVo() {
    }

    public ResponseCinemasVo(Integer status, Integer nowPage, Integer totalPage, T data) {
        this.status = status;
        this.nowPage = nowPage;
        this.totalPage = totalPage;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
