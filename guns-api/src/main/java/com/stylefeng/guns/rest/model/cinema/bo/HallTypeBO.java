package com.stylefeng.guns.rest.model.cinema.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 22:59
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HallTypeBO implements Serializable {
    private Integer halltypeId;
    private String halltypeName;
    private boolean isActive;
}
