package com.wangwei.errorpage;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {IllegalAccessException.class})
    @ResponseBody
    public String globalErrorHandler(Exception e){
        return "global Exception Handler:"+e.getMessage();
    }
}
