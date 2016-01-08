package com.zuozuo.views.home.web;

import com.zuozuo.converter.user.UserDTOConverter;
import com.zuozuo.dto.user.ApiBasicUserDTO;
import com.zuozuo.forms.LoginForm;
import com.zuozuo.service.user.IUserCoreService;
import com.zuozuo.service.user.LoginInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * Created by bug on 15/12/30.
 */
@Controller
public class HomeController {

  @Resource
  private IUserCoreService userCoreService;

  @RequestMapping(value = {"/", "index/"}, method = RequestMethod.GET)
  public String home() {
    return "home/main";
  }

  @RequestMapping(value = "upload/", method = RequestMethod.POST)
  public String upload() {
    return "home/upload";
  }

  @RequestMapping(value = "login/", method = RequestMethod.GET)
  public String loginPage() {
    return "home/login";
  }

  @RequestMapping(value = "login/", method = RequestMethod.POST)
  public String login(@ModelAttribute LoginForm loginForm, Model model) {
    if (loginForm == null || StringUtils.isEmpty(loginForm.getUsername()) || StringUtils.isEmpty
        (loginForm.getPassword())) {
      model.addAttribute("error_message", "empty username or password");
      return "home/login";
    }

    LoginInfo loginInfo = userCoreService.validateUsernameAndPassword(loginForm.getUsername(),
        loginForm.getPassword());
    if (loginInfo.isSuccess()) {
      ApiBasicUserDTO apiBasicUserDTO = UserDTOConverter.conv(loginInfo.getUser());
      model.addAttribute("login_user", apiBasicUserDTO);
    } else {
      model.addAttribute("error_message", loginInfo.getMessage());
      return "home/login";
    }
    return "redirect:/";
  }
}
