package com.wangwei.errorpage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangwei on 2018/1/17.
 */
@Controller
public class MyExceptionHandleController {

    /**
     * 定义在Controller内部，只对该Controller内的请求有效,
     * 可以注入Exception对象，获取异常详细信息
     * @return
     */
    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseBody
    public String errorHandle(Exception e){
        return "IllegalArgumentException happen: " + e.getMessage();
    }

    @RequestMapping(value = "/error")
    public String error(){
        throw new IllegalArgumentException("IllegalArgumentException-->MyExceptionHandleController");
    }

    @RequestMapping(value = "/error2")
    public String error2(){
        throw new NullPointerException("NullPointerException-->MyExceptionHandleController");
    }
}
