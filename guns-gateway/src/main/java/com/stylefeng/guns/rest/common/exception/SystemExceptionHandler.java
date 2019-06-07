package com.stylefeng.guns.rest.common.exception;

import com.stylefeng.guns.rest.model.cinema.responsevo.ResponseExceptionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Ethan New
 * @Date: 2019/6/7 16:57
 * @Description:
 */

@ControllerAdvice
public class SystemExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemExceptionHandler.class);

    /**
     * 处理所有不可知的异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseExceptionVO handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);

        ResponseExceptionVO response = new ResponseExceptionVO();
        response.setStatus(999);
        response.setMsg("系统出现异常，联系管理员！");
        return response;
    }
}