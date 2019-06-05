package com.stylefeng.guns.user.modular.MyexceptionHandler;

import com.stylefeng.guns.user.modular.utiles.ResponseResult;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


public class PublicExceptionHandle implements HandlerExceptionResolver {

    @ExceptionHandler(Exception.class)
    public Map resolveException(Exception e) {
        LoggerFactory.getLogger(getClass()).info(e.getMessage());
        return ResponseResult.responseResult("系统出现异常，请联系管理员", 999);
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        LoggerFactory.getLogger(getClass()).info(e.getMessage());

         ResponseResult.responseResult("系统出现异常，请联系管理员", 999);
         return new ModelAndView();
    }
}
