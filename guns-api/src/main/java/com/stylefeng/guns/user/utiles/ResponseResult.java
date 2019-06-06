package com.stylefeng.guns.user.utiles;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ResponseResult<T> implements Serializable {
   private String msg;
    private int status;
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult() {
    }

    public ResponseResult responseResult(String msg, int status){
        ResponseResult result = new ResponseResult();
        result.setMsg(msg);
        result.setStatus(status);
        return result;
    }

    public ResponseResult responseResult(String msg,int status, T data){
        ResponseResult<T> result = new ResponseResult<>();
        result.setData(data);
        result.setMsg(msg);
        result.setStatus(status);
        return result;
    }
}
