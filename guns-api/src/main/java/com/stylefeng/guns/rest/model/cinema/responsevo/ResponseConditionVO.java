package com.stylefeng.guns.rest.model.cinema.responsevo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:08
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseConditionVO<T> {
    private Integer status;
    private T data;
}
