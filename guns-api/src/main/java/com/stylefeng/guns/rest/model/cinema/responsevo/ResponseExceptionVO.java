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
public class ResponseExceptionVO {
    private Integer status;
    private String msg;
}
