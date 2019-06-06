package com.stylefeng.guns.rest.modular.film.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.BannerVO;
import com.stylefeng.guns.api.film.vo.FilmInfo;
import com.stylefeng.guns.api.film.vo.FilmVO;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeBannerTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeBannerT;
import com.stylefeng.guns.rest.common.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.model.cinema.bo.FilmBo;
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
    public FilmVO getHotFilms(boolean isLimit, int nums) {
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


        }

        return filmVO;
    }

    @Override
    public FilmVO getSoonFilms(boolean isLimit, int nums) {

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


        }
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
    public List<FilmBo> getFilmList() {
        List<FilmBo> filmBos = mtimeFilmTMapper.getFilmList();
        return filmBos;
    }

}
