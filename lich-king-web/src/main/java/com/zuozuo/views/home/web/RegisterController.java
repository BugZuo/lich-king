package com.zuozuo.views.home.web;

import com.zuozuo.check.CheckResult;
import com.zuozuo.check.home.RegisterCheckService;
import com.zuozuo.forms.RegisterForm;

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
  private RegisterCheckService registerCheckService;

  @RequestMapping(value = "register/", method = RequestMethod.GET)
  public String registerPage() {
    return "home/register";
  }

  @RequestMapping(value = "register/", method = RequestMethod.POST)
  public String register(RegisterForm registerForm, Model model) {
    CheckResult checkResult = registerCheckService.checkRegisterForm(registerForm);
    if (checkResult.isSuccess()) {
      // TODO 成功之后的逻辑
    } else {
      model.addAttribute("error_message", checkResult.getMessage());
      return "home/register";
    }
    return "redirect:/";
  }
}
