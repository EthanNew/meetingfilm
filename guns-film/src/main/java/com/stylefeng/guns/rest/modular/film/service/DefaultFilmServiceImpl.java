package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.*;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
import com.stylefeng.guns.rest.model.cinema.bo.FilmBO;
import com.stylefeng.guns.rest.model.cinema.bo.FilmInfoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service(interfaceClass = FilmServiceApi.class)
public class DefaultFilmServiceImpl implements FilmServiceApi {

    @Autowired
    private MtimeBannerTMapper mtimeBannerTMapper;
    @Autowired
    private MtimeFilmTMapper mtimeFilmTMapper;
    @Autowired
    private MtimeCatDictTMapper mtimeCatDictTMapper;
    @Autowired
    private MtimeSourceDictTMapper mtimeSourceDictTMapper;
    @Autowired
    private MtimeYearDictTMapper mtimeYearDictTMapper;
    @Autowired
    private MtimeFilmInfoTMapper mtimeFilmInfoTMapper;
    @Autowired
    private MtimeActorTMapper mtimeActorTMapper;

    @Override
    public List<BannerVO> getBanners() {
        List<BannerVO> result = new ArrayList<>();
        List<MtimeBannerT> mtimeBanners = mtimeBannerTMapper.selectList(null);
        for (MtimeBannerT mtimeBannerT : mtimeBanners) {
            BannerVO bannerVO = new BannerVO();
            bannerVO.setBannerId(mtimeBannerT.getUuid()+"");
            bannerVO.setBannerUrl(mtimeBannerT.getBannerUrl());
            bannerVO.setBannerAddress(mtimeBannerT.getBannerAddress());
            result.add(bannerVO);
        }
        return result;
    }

    private List<FilmInfo> getFilmInfos(List<MtimeFilmT> mtimeFilmTS){
        List<FilmInfo> filmInfos = new ArrayList<>();
        for(MtimeFilmT mtimeFilmT : mtimeFilmTS){
            FilmInfo filmInfo = new FilmInfo();
            filmInfo.setScore(mtimeFilmT.getFilmScore());
            filmInfo.setImgAddress(mtimeFilmT.getImgAddress());
            filmInfo.setFilmType(mtimeFilmT.getFilmType());
            filmInfo.setFilmScore(mtimeFilmT.getFilmScore());
            filmInfo.setFilmName(mtimeFilmT.getFilmName());
            filmInfo.setFilmId(mtimeFilmT.getUuid()+"");
            filmInfo.setExpectNum(mtimeFilmT.getFilmPresalenum());
            filmInfo.setBoxNum(mtimeFilmT.getFilmBoxOffice());
            filmInfo.setShowTime(DateUtil.getDay(mtimeFilmT.getFilmTime()));

            // 将转换的对象放入结果集
            filmInfos.add(filmInfo);
        }

        return filmInfos;
    }

    @Override
    public FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");
        if (isLimit){
            Page<MtimeFilmT> page = new Page<>(1,nums);
            List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(mtimeFilmTS);
            filmVO.setFilmNum(mtimeFilmTS.size());
            filmVO.setFilmInfo(filmInfos);
        }else{
            Page<MtimeFilmT> page = null;
            switch (sortId) {
                case 1:
                    page = new Page<>(nowPage, nums, "film_box_office");
                    break;
                case 2:
                    page = new Page<>(nowPage, nums, "film_time");
                    break;
                case 3:
                    page = new Page<>(nowPage, nums, "film_score");
                    break;
                default:
                    page = new Page<>(nowPage, nums, "film_box_office");
                    break;
            }
            if (sourceId != 99) {
                entityWrapper.eq("film_source", sourceId);
            }
            if (yearId != 99) {
                entityWrapper.eq("film_date", yearId);
            }
            if (catId != 99) {
                String catStr = "%#" + catId + "#%";
                entityWrapper.like("film_cats", catStr);
            }
            List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(mtimeFilmTS);
            filmVO.setFilmNum(mtimeFilmTS.size());
            // 需要总页数 totalCounts/nums
            int totalCounts = mtimeFilmTMapper.selectCount(entityWrapper);
            int totalPages = (totalCounts / nums) + 1;
            filmVO.setFilmInfo(filmInfos);
            filmVO.setTotalPage(totalPages);
            filmVO.setNowPage(nowPage);
        }

        return filmVO;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {

        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","2");
        if (isLimit){
            Page<MtimeFilmT> page = new Page<>(1,nums);
            List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(mtimeFilmTS);
            filmVO.setFilmNum(mtimeFilmTS.size());
            filmVO.setFilmInfo(filmInfos);
        }else{
            Page<MtimeFilmT> page = null;
            switch (sortId) {
                case 1:
                    page = new Page<>(nowPage, nums, "film_preSaleNum");
                    break;
                case 2:
                    page = new Page<>(nowPage, nums, "film_time");
                    break;
                case 3:
                    page = new Page<>(nowPage, nums, "film_preSaleNum");
                    break;
                default:
                    page = new Page<>(nowPage, nums, "film_preSaleNum");
                    break;
            }
            if (sourceId != 99) {
                entityWrapper.eq("film_source", sourceId);
            }
            if (yearId != 99) {
                entityWrapper.eq("film_date", yearId);
            }
            if (catId != 99) {
                String catStr = "%#" + catId + "#%";
                entityWrapper.like("film_cats", catStr);
            }
            List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page, entityWrapper);
            filmInfos = getFilmInfos(mtimeFilmTS);
            filmVO.setFilmNum(mtimeFilmTS.size());
            int totalCounts = mtimeFilmTMapper.selectCount(entityWrapper);
            int totalPages = (totalCounts / nums) + 1;
            filmVO.setFilmInfo(filmInfos);
            filmVO.setTotalPage(totalPages);
            filmVO.setNowPage(nowPage);
        }
        return filmVO;
    }

    @Override
    public FilmVO getClassicFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId) {
        FilmVO filmVO = new FilmVO();
        List<FilmInfo> filmInfos = new ArrayList<>();
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status", "3");
        Page<MtimeFilmT> page = null;
        switch (sortId) {
            case 1:
                page = new Page<>(nowPage, nums, "film_box_office");
                break;
            case 2:
                page = new Page<>(nowPage, nums, "film_time");
                break;
            case 3:
                page = new Page<>(nowPage, nums, "film_score");
                break;
            default:
                page = new Page<>(nowPage, nums, "film_box_office");
                break;
        }
        if (sourceId != 99) {
            entityWrapper.eq("film_source", sourceId);
        }
        if (yearId != 99) {
            entityWrapper.eq("film_date", yearId);
        }
        if (catId != 99) {
            String catStr = "%#" + catId + "#%";
            entityWrapper.like("film_cats", catStr);
        }
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page, entityWrapper);
        filmInfos = getFilmInfos(mtimeFilmTS);
        filmVO.setFilmNum(mtimeFilmTS.size());
        // 需要总页数 totalCounts/nums
        int totalCounts = mtimeFilmTMapper.selectCount(entityWrapper);
        int totalPages = (totalCounts / nums) + 1;
        filmVO.setFilmInfo(filmInfos);
        filmVO.setTotalPage(totalPages);
        filmVO.setNowPage(nowPage);

        return filmVO;
    }



    @Override
    public List<FilmInfo> getBoxRanking() {
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");
        Page<MtimeFilmT> page = new Page<>(1,10,"film_box_office");
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page,entityWrapper);
        List<FilmInfo> filmInfos = getFilmInfos(mtimeFilmTS);

        return filmInfos;
    }

    @Override
    public List<FilmInfo> getExpectRanking() {
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","2");
        Page<MtimeFilmT> page = new Page<>(1,10,"film_preSaleNum");
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page,entityWrapper);
        List<FilmInfo> filmInfos = getFilmInfos(mtimeFilmTS);

        return filmInfos;
    }

    @Override
    public List<FilmInfo> getTop() {
        EntityWrapper<MtimeFilmT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("film_status","1");
        Page<MtimeFilmT> page = new Page<>(1,10,"film_score");
        List<MtimeFilmT> mtimeFilmTS = mtimeFilmTMapper.selectPage(page,entityWrapper);
        List<FilmInfo> filmInfos = getFilmInfos(mtimeFilmTS);

        return filmInfos;
    }
    @Override
    public List<FilmBO> getFilmList() {
        List<FilmBO> filmBos = mtimeFilmTMapper.getFilmList();
        return filmBos;
    }

    @Override
    public List<CatVO> getCats() {
        List<CatVO> cats = new ArrayList<>();
        List<MtimeCatDictT> mtimeCatDictTS = mtimeCatDictTMapper.selectList(null);
        for (MtimeCatDictT mtimeCatDictT : mtimeCatDictTS) {
            CatVO catVO = new CatVO();
            catVO.setCatId(mtimeCatDictT.getUuid() + "");
            catVO.setCatName(mtimeCatDictT.getShowName());
            cats.add(catVO);
        }

        return cats;
    }

    @Override
    public List<SourceVO> getSources() {
        List<SourceVO> sources = new ArrayList<>();
        List<MtimeSourceDictT> mtimeSourceDictTS = mtimeSourceDictTMapper.selectList(null);
        for (MtimeSourceDictT mtimeSourceDictT : mtimeSourceDictTS) {
            SourceVO sourceVO = new SourceVO();
            sourceVO.setSourceId(mtimeSourceDictT.getUuid() + "");
            sourceVO.setSourceName(mtimeSourceDictT.getShowName());
            sources.add(sourceVO);
        }

        return sources;
    }

    @Override
    public List<YearVO> getYears() {
        List<YearVO> years = new ArrayList<>();
        List<MtimeYearDictT> mtimeYearDictTS = mtimeYearDictTMapper.selectList(null);
        for (MtimeYearDictT mtimeYearDictT : mtimeYearDictTS) {
            YearVO yearVO = new YearVO();
            yearVO.setYearId(mtimeYearDictT.getUuid() + "");
            yearVO.setYearName(mtimeYearDictT.getShowName());
            years.add(yearVO);
        }

        return years;
    }

    @Override
    public FilmDetailVO getFilmDetail(int searchType, String searchParam) {
        FilmDetailVO filmDetailVO = null;
        if (searchType == 1){
            filmDetailVO = mtimeFilmTMapper.getFilmDetailByName("%"+searchParam+"%");
        }else{
            filmDetailVO = mtimeFilmTMapper.getFilmDetailById(searchParam);
        }
        return filmDetailVO;
    }


    private MtimeFilmInfoT getFilmInfo(String filmId){

        MtimeFilmInfoT mtimeFilmInfoT = new MtimeFilmInfoT();
        mtimeFilmInfoT.setFilmId(filmId);

        mtimeFilmInfoT= mtimeFilmInfoTMapper.selectOne(mtimeFilmInfoT);

        return mtimeFilmInfoT;
    }

    @Override
    public FilmDescVO getFilmDesc(String filmId) {
        MtimeFilmInfoT mtimeFilmInfoT = getFilmInfo(filmId);

        FilmDescVO filmDescVO = new FilmDescVO();
        filmDescVO.setBiography(mtimeFilmInfoT.getBiography());
        filmDescVO.setFilmId(filmId);

        return filmDescVO;
    }

    @Override
    public ImgVO getImgs(String filmId) {

        MtimeFilmInfoT mtimeFilmInfoT = getFilmInfo(filmId);
        String filmImgStr = mtimeFilmInfoT.getFilmImgs();
        String[] filmImgs = filmImgStr.split(",");
        ImgVO imgVO = new ImgVO();
        imgVO.setMainImg(filmImgs[0]);
        imgVO.setImg01(filmImgs[1]);
        imgVO.setImg02(filmImgs[2]);
        imgVO.setImg03(filmImgs[3]);
        imgVO.setImg04(filmImgs[4]);

        return imgVO;
    }

    @Override
    public ActorVO getDectInfo(String filmId) {
        MtimeFilmInfoT mtimeFilmInfoT = getFilmInfo(filmId);
        Integer directId = mtimeFilmInfoT.getDirectorId();
        MtimeActorT mtimeActorT = mtimeActorTMapper.selectById(directId);
        ActorVO actorVO = new ActorVO();
        actorVO.setImgAddress(mtimeActorT.getActorImg());
        actorVO.setDirectorName(mtimeActorT.getActorName());
        return actorVO;
    }

    @Override
    public List<ActorVO> getActors(String filmId) {
        List<ActorVO> actors = mtimeActorTMapper.getActors(filmId);

        return actors;
    }

    @Override
    public FilmInfoBO getFilmByFieldId(int fieldId) {
        FilmInfoBO filmInfoBO = mtimeFilmTMapper.getFilmByFieldId(fieldId);
        return filmInfoBO;
    }


}
