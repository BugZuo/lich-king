package com.zuozuo.views.home.api;

import com.zuozuo.common.security.LoginUtil;
import com.zuozuo.model.user.LoginUser;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bug on 15/12/7.
 */
@RestController
@RequestMapping("api")
public class HomeApi {

    @RequestMapping(value = "hi/", method = RequestMethod.GET)
    public String hi() {
        LoginUser loginUser = LoginUtil.getLoginUser();
        return "hi" + ": " + loginUser != null ? loginUser.getUsername() : "shit";
    }
}
