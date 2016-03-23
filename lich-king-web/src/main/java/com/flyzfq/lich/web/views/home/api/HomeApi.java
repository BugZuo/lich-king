package com.flyzfq.lich.web.views.home.api;

import com.flyzfq.lich.biz.security.LoginUtil;
import com.flyzfq.lich.model.user.LoginUser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bug on 15/12/7.
 */
@RestController
@RequestMapping("api")
public class HomeApi {

  private static final Logger logger = LoggerFactory.getLogger(HomeApi.class);

  @RequestMapping(value = "hi/", method = RequestMethod.GET)
  public String hi() {
    LoginUser loginUser = LoginUtil.getLoginUser();
    logger.info("hi" + ": " + (loginUser != null ? loginUser.getUsername() : "shit"));
    return "hi" + ": " + (loginUser != null ? loginUser.getUsername() : "shit");
  }
}
