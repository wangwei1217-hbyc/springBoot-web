package com.wangwei.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * --@GetMapping、@PostMapping等是Spring4.3之后的新特性
 * 在SpringBoot中使用jsp，需要加入依赖
 * <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
    </dependency>
    同时需要在appliation.properties配置文件中配置如下属性（参见WebMvcProperties类）：
        spring.mvc.view.prefix=/WEB-INF/jsp/
        spring.mvc.view.suffix=.jsp

    注意：SpringBoot中同时只支持一种渲染方式.
        如果项使用FreeMarker模版方式渲染页面，需要注掉jsp的相关配置，同时引入freemarker的依赖
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
         </dependency>
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(){
        return "success";
    }
    /**jsp**/
    @RequestMapping(value = "/demo")
    public String demo(){
        return "demo";
    }

    /**ftl**/
    @RequestMapping(value = "/b")
    public String b(Model model){
        model.addAttribute("name","胡英");
        model.addAttribute("sex","male");
        ArrayList<String> list = new ArrayList<>();
        list.add("wangwei");
        list.add("love");
        list.add("huying");
        model.addAttribute("list",list);
        return "b";
    }
}
