package com.flyzfq.lich.web.views.home.web;

import com.flyzfq.lich.common.result.CheckResult;
import com.flyzfq.lich.web.component.user.UserComponent;
import com.flyzfq.lich.web.forms.RegisterForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bug on 16/1/11.
 */
@Controller
public class RegisterController {

  @Autowired
  private UserComponent userComponent;

  @RequestMapping(value = "register/", method = RequestMethod.GET)
  public String registerPage() {
    return "home/register";
  }

  @RequestMapping(value = "register/", method = RequestMethod.POST)
  public String register(RegisterForm registerForm, Model model) {
    CheckResult checkResult = userComponent.checkRegisterForm(registerForm);
    if (checkResult.isHasError()) {
      model.addAttribute("error_message", checkResult.getMessage());
      return "home/register";
    } else {
      // TODO 成功之后的逻辑
    }
    return "redirect:/";
  }
}
