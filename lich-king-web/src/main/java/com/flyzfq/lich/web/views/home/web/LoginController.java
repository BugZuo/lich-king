package com.flyzfq.lich.web.views.home.web;

import com.flyzfq.lich.biz.service.user.ISessionManager;
import com.flyzfq.lich.biz.service.user.IUserCoreService;
import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.model.user.LoginUser;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;
import com.flyzfq.lich.web.assember.user.ApiUserAssemberAdapter;
import com.flyzfq.lich.web.dto.user.ApiBasicUserDTO;
import com.flyzfq.lich.web.forms.LoginForm;

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
    if (loginForm == null || StringUtils.isEmpty(loginForm.getUsername()) || StringUtils.isEmpty(
        loginForm.getPassword())) {
      model.addAttribute("error_message", "empty username or password");
      return "home/login";
    }
    BaseResult<BaseUserDTO> result = userCoreService.validateUsernameAndPassword(
        loginForm.getUsername(), loginForm.getPassword());
    if (result.isSuccess()) {
      BaseUserDTO user = result.getResult();
      ApiBasicUserDTO apiBasicUserDTO = ApiUserAssemberAdapter.conv(user);
      model.addAttribute("login_user", apiBasicUserDTO);
      LoginUser loginUser = new LoginUser();
      loginUser.setUserId(user.getId());
      loginUser.setUsername(user.getUsername());
//      loginUser.setBindStatus();
      loginUser.setCookieAge(loginForm.isRemeber() ? ISessionManager.REMEMBER_COOKIE_AGE :
          ISessionManager.COOKIE_AGE);
      sessionManager.saveSessionAndSetCookie(loginUser, response);
    } else {
      model.addAttribute("error_message", result.getMessage());
      return "home/login";
    }
    return "redirect:/";
  }
}
