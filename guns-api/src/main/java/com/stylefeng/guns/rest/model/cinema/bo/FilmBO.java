package com.stylefeng.guns.rest.model.cinema.bo;


import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/6/5 17:58
 * @Description:
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilmBO implements Serializable {
    private Integer filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private List<FilmBO> filmFields;
}
