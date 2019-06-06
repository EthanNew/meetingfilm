package com.stylefeng.guns.rest.model.cinema.responsevo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 19:26
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseExceptionVo {
    private Integer status;
    private String msg;

    public ResponseExceptionVo(int i, String 影院信息查询失败) {

    }
}
