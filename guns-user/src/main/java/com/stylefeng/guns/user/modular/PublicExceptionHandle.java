package com.stylefeng.guns.user.modular;

import com.stylefeng.guns.user.modular.utiles.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
@Component
public class PublicExceptionHandle implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object o, Exception e) {
        Logger.getLogger(getClass()).info(e);
        Map map = ResponseResult.responseResult("系统出现异常，请联系管理员", 999);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(map);
        return modelAndView;
    }
}
