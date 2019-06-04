package com.stylefeng.guns.rest.modular.cinema;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.model.cinema.bo.CinemaBo;
import com.stylefeng.guns.rest.model.cinema.requestvo.RequestCinemasVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 16:44
 * @Description:
 */

@RestController
@RequestMapping("/cinema")
public class CinemaController {

    @Reference
    CinemaService cinemaService;

    @GetMapping("/getCinemas")
    public void getCinemas(RequestCinemasVo requestCinemasVo) {
        List<CinemaBo> list = cinemaService.getCinemas(requestCinemasVo);
    }
}
