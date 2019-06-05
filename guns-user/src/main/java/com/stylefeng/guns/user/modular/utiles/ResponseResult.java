package com.stylefeng.guns.user.modular.utiles;

import java.util.HashMap;
import java.util.Map;

public class ResponseResult {
/*    private String msg;
    private int status;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseResult() {
    }

    public ResponseResult(String msg, int status, Object data) {
        this.msg = msg;
        this.status = status;
        this.data = data;
    }*/

    public static Map responseResult(String msg, int status){
        Map map = new HashMap<>();
        map.put("msg",msg);
        map.put("status",status);
        return map;
    }
}
