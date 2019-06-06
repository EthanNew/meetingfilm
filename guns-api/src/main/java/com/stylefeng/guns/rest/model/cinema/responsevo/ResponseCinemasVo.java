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
public class ResponseCinemasVo<T> {
    private Integer status;
    private Integer nowPage;
    private Integer totalPage;
    private T data;

    public ResponseCinemasVo(int i, Integer nowPage, int totalPage, T list) {

    }
}
