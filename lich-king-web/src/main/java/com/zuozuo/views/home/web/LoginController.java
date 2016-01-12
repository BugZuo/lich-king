package com.zuozuo.views.home.web;

import com.zuozuo.converter.user.UserDTOConverter;
import com.zuozuo.dto.user.ApiBasicUserDTO;
import com.zuozuo.forms.LoginForm;
import com.zuozuo.model.user.LoginCheckResult;
import com.zuozuo.model.user.LoginUser;
import com.zuozuo.service.user.ISessionManager;
import com.zuozuo.service.user.IUserCoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by bug on 16/1/11.
 */
@Controller
public class LoginController {

  @Autowired
  private IUserCoreService userCoreService;

  @Autowired
  private ISessionManager sessionManager;

  @RequestMapping(value = "login/", method = RequestMethod.GET)
  public String loginPage() {
    return "home/login";
  }

  @RequestMapping(value = "login/", method = RequestMethod.POST)
  public String login(HttpServletResponse response, @ModelAttribute LoginForm loginForm, Model
      model) {
    if (loginForm == null || StringUtils.isEmpty(loginForm.getUsername()) || StringUtils.isEmpty
        (loginForm.getPassword())) {
      model.addAttribute("error_message", "empty username or password");
      return "home/login";
    }

    LoginCheckResult loginCheckResult = userCoreService.validateUsernameAndPassword(loginForm.getUsername(),
        loginForm.getPassword());
    if (loginCheckResult.isSuccess()) {
      ApiBasicUserDTO apiBasicUserDTO = UserDTOConverter.conv(loginCheckResult.getUser());
      model.addAttribute("login_user", apiBasicUserDTO);
      LoginUser loginUser = new LoginUser();
      loginUser.setUserId(loginCheckResult.getUser().getId());
      loginUser.setUsername(loginCheckResult.getUser().getUsername());
//      loginUser.setBindStatus();
      loginUser.setCookieAge(loginForm.isRemeber() ? ISessionManager.REMEMBER_COOKIE_AGE :
          ISessionManager.COOKIE_AGE);
      sessionManager.saveSessionAndSetCookie(loginUser, response);
    } else {
      model.addAttribute("error_message", loginCheckResult.getMessage());
      return "home/login";
    }
    return "redirect:/";
  }
}
