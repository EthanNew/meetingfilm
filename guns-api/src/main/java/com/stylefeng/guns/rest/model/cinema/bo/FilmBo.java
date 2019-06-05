package com.stylefeng.guns.rest.model.cinema.bo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author: Ethan New
 * @Date: 2019/6/5 17:58
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilmBo implements Serializable {
    private Integer filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private FieldBo filmFields;
}
