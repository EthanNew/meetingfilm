package com.stylefeng.guns.user.modular.MyexceptionHandler;

import com.stylefeng.guns.user.modular.utiles.ResponseResult;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Component
public class PublicExceptionHandle implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        LoggerFactory.getLogger(getClass()).info(e.getMessage());
        Map map = new HashMap();

        if(e instanceof SQLException){
            map = ResponseResult.responseResult("系统出现异常，请联系管理员", 999);

        }
        else {
            map = ResponseResult.responseResult("系统出现异常，请联系管理员", 999);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(map);
        return modelAndView;

        /*

        ResponseDTO response = ResponseDTO.builder()
        .errorCode(ErrorCode.SYSTEM_ERROR)
        .build();
        byte[] bytes = JSON.toJSONString(response).getBytes(StandardCharsets.UTF_8));
        try {
            FileCopyUtils.copy(bytes, response.getOutputStream());
        } catch (IOException e) {
            log.error("error", e);
            throw new RuntimeException(e);
        }
        return new ModelAndView();
    }
        * */
    }



}
