package com.stylefeng.guns.rest.modular.film;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.api.film.vo.*;
import com.stylefeng.guns.rest.modular.film.vo.FilmConditionVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.film.vo.FilmRequestVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    private static final String img_pre = "http://img.meetingshop.cn/";

    @Reference
    private FilmServiceApi filmServiceApi;

    //首页接口
    @RequestMapping(value = "/getIndex",method = RequestMethod.GET)
    public ResponseVO<FilmIndexVO> getIndex(){
        FilmIndexVO filmIndexVO = new FilmIndexVO();

        //获取横幅
        filmIndexVO.setBanners(filmServiceApi.getBanners());

        //正在热映
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true,8,1,1,99,99,99));

        //即将上映
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true,8,1,1,99,99,99));

        //票房排行榜
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());

        //受欢迎排行榜
        filmIndexVO.setExpectRanking(filmServiceApi.getExpectRanking());

        //top100
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(img_pre,filmIndexVO);
    }


    @RequestMapping(value = "/getConditionList",method = RequestMethod.GET)
    public ResponseVO getConditionList(@RequestParam(name = "catId",required = false,defaultValue = "99")String catId,
                                       @RequestParam(name = "sourceId",required = false,defaultValue = "99")String sourceId,
                                       @RequestParam(name = "yearId",required = false,defaultValue = "99")String yearId){
        FilmConditionVO filmConditionVO = new FilmConditionVO();
        boolean flag = false;
        //类型集合
        List<CatVO> cats = filmServiceApi.getCats();
        List<CatVO> catResult = new ArrayList<>();
        CatVO catVO = null;
        for (CatVO cat : cats) {
            if (cat.getCatId().equals("99")){
                catVO = cat;
                continue;
            }
            if (cat.getCatId().equals(catId)){
                flag = true;
                cat.setActive(true);
            }else {
                cat.setActive(false);
            }
            catResult.add(cat);
        }
        if (!flag){
            catVO.setActive(true);
            catResult.add(catVO);
        }else {
            catVO.setActive(false);
            catResult.add(catVO);
        }
        //片源集合
        flag = false;
        List<SourceVO> sources = filmServiceApi.getSources();
        List<SourceVO> sourceResult = new ArrayList<>();
        SourceVO sourceVO = null;
        for (SourceVO source : sources) {
            if (source.getSourceId().equals("99")){
                sourceVO = source;
                continue;
            }
            if (source.getSourceId().equals(catId)){
                flag = true;
                source.setActive(true);
            }else {
                source.setActive(false);
            }
            sourceResult.add(source);
        }
        if (!flag){
            sourceVO.setActive(true);
            sourceResult.add(sourceVO);
        }else {
            sourceVO.setActive(false);
            sourceResult.add(sourceVO);
        }
        //年代集合
        flag=false;
        List<YearVO> years = filmServiceApi.getYears();
        List<YearVO> yearResult = new ArrayList<>();
        YearVO yearVO = null;
        for(YearVO year : years){
            if(year.getYearId().equals("99")){
                yearVO = year;
                continue;
            }
            if(year.getYearId().equals(catId)){
                flag = true;
                year.setActive(true);
            }else{
                year.setActive(false);
            }
            yearResult.add(year);
        }
        if(!flag){
            yearVO.setActive(true);
            yearResult.add(yearVO);
        }else{
            yearVO.setActive(false);
            yearResult.add(yearVO);
        }

        filmConditionVO.setCatInfo(catResult);
        filmConditionVO.setSourceInfo(sourceResult);
        filmConditionVO.setYearInfo(yearResult);
        return ResponseVO.success(filmConditionVO);

    }


    @RequestMapping(value = "/getFilms",method = RequestMethod.GET)
    public ResponseVO getFilms(FilmRequestVO filmRequestVO){
        String img_pre = "http://img.meetingshop.cn/";

        FilmVO filmVO = null;
        // 根据showType判断影片查询类型
        switch (filmRequestVO.getShowType()){
            case 1 :
                filmVO = filmServiceApi.getHotFilms(
                        false,filmRequestVO.getPageSize(),filmRequestVO.getNowPage(),
                        filmRequestVO.getSortId(),filmRequestVO.getSourceId(),filmRequestVO.getYearId(),
                        filmRequestVO.getCatId());
                break;
            case 2 :
                filmVO = filmServiceApi.getSoonFilms(
                        false,filmRequestVO.getPageSize(),filmRequestVO.getNowPage(),
                        filmRequestVO.getSortId(),filmRequestVO.getSourceId(),filmRequestVO.getYearId(),
                        filmRequestVO.getCatId());
                break;
            case 3 :
                filmVO = filmServiceApi.getClassicFilms(
                        filmRequestVO.getPageSize(),filmRequestVO.getNowPage(),
                        filmRequestVO.getSortId(),filmRequestVO.getSourceId(),
                        filmRequestVO.getYearId(), filmRequestVO.getCatId());
                break;
            default:
                filmVO = filmServiceApi.getHotFilms(
                        false,filmRequestVO.getPageSize(),filmRequestVO.getNowPage(),
                        filmRequestVO.getSortId(),filmRequestVO.getSourceId(),filmRequestVO.getYearId(),
                        filmRequestVO.getCatId());
                break;
        }
        return ResponseVO.success(
                filmVO.getNowPage(),filmVO.getTotalPage(),
                img_pre,filmVO.getFilmInfo());

    }

    @RequestMapping(value = "/films/{searchParam}",method = RequestMethod.GET)
    public ResponseVO films(@PathVariable("searchParam")String searchParam, int searchType){

        FilmDetailVO filmDetail = filmServiceApi.getFilmDetail(searchType, searchParam);
        String filmId = filmDetail.getFilmId();

        FilmDescVO filmDescVO = filmServiceApi.getFilmDesc(filmId);
        ImgVO imgVO = filmServiceApi.getImgs(filmId);
        ActorVO directorVO = filmServiceApi.getDectInfo(filmId);
        List<ActorVO> actors = filmServiceApi.getActors(filmId);

        InfoRequestVO infoRequestVO = new InfoRequestVO();


        ActorRequestVO actorRequestVO = new ActorRequestVO();
        actorRequestVO.setActors(actors);
        actorRequestVO.setDirector(directorVO);


        infoRequestVO.setActors(actorRequestVO);
        infoRequestVO.setBiography(filmDescVO.getBiography());
        infoRequestVO.setFilmId(filmId);
        infoRequestVO.setImgVO(imgVO);


        filmDetail.setInfo04(infoRequestVO);

        return ResponseVO.success("http://img.meetingshop.cn/",filmDetail);

    }
}
