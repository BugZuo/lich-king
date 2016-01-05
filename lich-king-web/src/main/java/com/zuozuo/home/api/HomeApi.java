package com.zuozuo.home.api;

import com.zuozuo.common.SpringUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * Created by bug on 15/12/7.
 */
@Controller
@RequestMapping("api")
public class HomeApi {

    @RequestMapping(value = "hi/", method = RequestMethod.GET)
    @ResponseBody
    public String hi() {
        FreeMarkerConfigurer freeMarkerConfigurer = (FreeMarkerConfigurer) SpringUtil.getBean("freemarkerConfig");
        return "hi";
    }
}
