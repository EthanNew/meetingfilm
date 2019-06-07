package com.stylefeng.guns.rest.model.cinema.requestvo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:25
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestConditionVO implements Serializable {
    private Integer brandId;
    private Integer hallType;
    private Integer areaId;
}
