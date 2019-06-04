package com.stylefeng.guns.rest.modular.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.test.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ethan New
 * @Date: 2019/6/4 15:07
 * @Description:
 */

@RestController
public class TestController {

    @Reference
    TestService testService;

    @RequestMapping("test")
    public String test() {
        return testService.sayHello("Dubbo!");
    }
}
