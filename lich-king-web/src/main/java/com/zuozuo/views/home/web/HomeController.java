package com.zuozuo.views.home.web;

import com.zuozuo.converter.user.UserDTOConverter;
import com.zuozuo.dto.user.ApiBasicUserDTO;
import com.zuozuo.forms.LoginForm;
import com.zuozuo.model.user.LoginCheckResult;
import com.zuozuo.model.user.LoginUser;
import com.zuozuo.service.user.ISessionManager;
import com.zuozuo.service.user.IUserCoreService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bug on 15/12/30.
 */
@Controller
public class HomeController {

  @RequestMapping(value = {"/", "index/"}, method = RequestMethod.GET)
  public String home() {
    return "home/main";
  }

  @RequestMapping(value = "upload/", method = RequestMethod.POST)
  public String upload() {
    return "home/upload";
  }
}
