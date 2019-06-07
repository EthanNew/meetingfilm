package com.stylefeng.guns.rest.model.cinema.requestvo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 19:29
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCinemasVo implements Serializable {
    private Integer brandId;
    private Integer hallType;
    private Integer areaId;
    private Integer pageSize;
    private Integer nowPage;
}
