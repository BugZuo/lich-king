package com.flyzfq.lich.web.views.home.api;

import com.flyzfq.arthas.common.StringUtil;
import com.flyzfq.lich.biz.service.user.IUserCoreService;
import com.flyzfq.lich.common.result.CheckResult;
import com.flyzfq.lich.common.web.APIStatus;
import com.flyzfq.lich.common.web.StandardResponseAPI;
import com.flyzfq.lich.model.user.dto.RegisterInfoDTO;
import com.flyzfq.lich.web.component.user.UserComponent;
import com.flyzfq.lich.web.constants.RegisterCheckConstants;
import com.flyzfq.lich.web.forms.RegisterForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bug on 16/1/11.
 */
@RestController
@RequestMapping("api/")
public class RegisterApi {
  @Autowired
  private UserComponent userComponent;

  @Autowired
  private IUserCoreService userCoreService;

  @RequestMapping(value = "register/", method = RequestMethod.POST)
  public StandardResponseAPI register(@ModelAttribute RegisterForm registerForm) {
    CheckResult checkResult = userComponent.checkRegisterForm(registerForm);
    if (checkResult.isHasError()) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, checkResult.getMessage());
    }
    RegisterInfoDTO registerInfoDTO = userComponent.create(registerForm);
    Long userId = userCoreService.register(registerInfoDTO).getResult();
    return new StandardResponseAPI(APIStatus.SUCCESS, userId);
  }

  @RequestMapping(value = "check/username/", method = RequestMethod.POST)
  public StandardResponseAPI checkUsername(
      @RequestParam(value = "username", defaultValue = "") String username) {
    if (StringUtil.isEmpty(username)) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, RegisterCheckConstants
          .USERNAME_CANNOT_BE_EMPTY);
    }

    if (!StringUtil.isUsername(username)) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, RegisterCheckConstants
          .USERNAME_IS_INVALID);
    }

    return new StandardResponseAPI();
  }

  @RequestMapping(value = "check/email/", method = RequestMethod.POST)
  public StandardResponseAPI checkEmail(
      @RequestParam(value = "email", defaultValue = "") String email) {
    if (StringUtil.isEmail(email)) {
      return new StandardResponseAPI();
    }
    return new StandardResponseAPI(APIStatus.INVALID_PARAM, "邮件格式错误");
  }

  @RequestMapping(value = "check/telephone/", method = RequestMethod.POST)
  public StandardResponseAPI checkTelephone(
      @RequestParam(value = "telephone", defaultValue = "") String telephone) {
    if (StringUtil.isPhoneNumberValid(telephone)) {
      return new StandardResponseAPI();
    }
    return new StandardResponseAPI(APIStatus.INVALID_PARAM, "手机号码格式错误");
  }
}
