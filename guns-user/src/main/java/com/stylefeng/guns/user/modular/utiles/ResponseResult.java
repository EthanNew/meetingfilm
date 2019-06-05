package com.stylefeng.guns.user.modular.utiles;

import java.util.HashMap;
import java.util.Map;

public class ResponseResult {


    public static Map responseResult(String msg,int status){
        Map map = new HashMap<>();
        map.put("msg",msg);
        map.put("status",status);
        return map;
    }
}
