package com.stylefeng.guns.rest.model.cinema.bo;

/**
 * @Author: Ethan New
 * @Date: 2019/6/5 17:58
 * @Description:
 */

public class FilmBo {
    private Integer filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private FieldBo filmFields;

    public FilmBo() {
    }

    public FilmBo(Integer filmId, String filmName, String filmLength, String filmType, String filmCats, String actors, String imgAddress, FieldBo filmFields) {
        this.filmId = filmId;
        this.filmName = filmName;
        this.filmLength = filmLength;
        this.filmType = filmType;
        this.filmCats = filmCats;
        this.actors = actors;
        this.imgAddress = imgAddress;
        this.filmFields = filmFields;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public FieldBo getFilmFields() {
        return filmFields;
    }

    public void setFilmFields(FieldBo filmFields) {
        this.filmFields = filmFields;
    }
}
