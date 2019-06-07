package com.stylefeng.guns.rest.model.cinema.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/5 17:25
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CinemaInfoBO implements Serializable {
    private Integer cinemaId;
    private String cinemaName;
    private String cinemaPhone;
    private String imgUrl;
    private String cinemaAddress;
}
