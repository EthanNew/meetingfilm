package com.stylefeng.guns.rest.modular.film;


import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.film.FilmServiceApi;
import com.stylefeng.guns.rest.modular.film.vo.FilmIndexVO;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        filmIndexVO.setHotFilms(filmServiceApi.getHotFilms(true,8));

        //即将上映
        filmIndexVO.setSoonFilms(filmServiceApi.getSoonFilms(true,8));

        //票房排行榜
        filmIndexVO.setBoxRanking(filmServiceApi.getBoxRanking());

        //受欢迎排行榜
        filmIndexVO.setExpectRanking(filmServiceApi.getExpectRanking());

        //top100
        filmIndexVO.setTop100(filmServiceApi.getTop());

        return ResponseVO.success(img_pre,filmIndexVO);
    }
}
