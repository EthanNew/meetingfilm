package com.stylefeng.guns.rest.model.cinema.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


/**
 * @Author: Ethan New
 * @Date: 2019/6/5 18:01
 * @Description:
 */


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FieldBO implements Serializable {
    private Integer fieldId;
    private String beginTime;
    private String endTime;
    private String language;
    private String hallName;
    private Integer price;
}
