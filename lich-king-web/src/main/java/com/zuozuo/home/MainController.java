package com.zuozuo.home;

import com.zuozuo.model.user.BaseUser;
import com.zuozuo.service.user.IUserCoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bug on 15/11/25.
 */
@Controller
public class MainController {

    @Autowired
    private IUserCoreService userCoreService;

    @RequestMapping(value = "hello/", method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "hi/", method = RequestMethod.GET)
    public String hi() {
        return "index";
    }

    @RequestMapping(value = "mybatis", method = RequestMethod.GET)
    @ResponseBody
    public String mybatis() {
        BaseUser user = userCoreService.getById(1);
        return "mybatis " + user.getUsername() + " " + user.getId();
    }
}
