package com.stylefeng.guns.rest.modular.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.cinema.CinemaService;
import org.springframework.stereotype.Component;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 17:03
 * @Description:
 */

@Component
@Service(interfaceClass = CinemaService.class)
public class CinemaServiceImpl implements CinemaService {

}
