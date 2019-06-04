package com.stylefeng.guns.rest.test.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.test.TestService;
import org.springframework.stereotype.Component;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 14:54
 * @Description:
 */

@Component
@Service(interfaceClass = TestService.class)
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello(String message) {
        return "Hello " + message;
    }
}
