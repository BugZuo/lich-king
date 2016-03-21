package com.flyzfq.lich.web.views.home.api;

import com.flyzfq.arthas.common.StringUtil;
import com.flyzfq.lich.common.web.APIStatus;
import com.flyzfq.lich.common.web.StandardResponseAPI;
import com.flyzfq.lich.web.constants.RegisterCheckConstants;

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
  @RequestMapping(value = "check/username/", method = RequestMethod.POST)
  public StandardResponseAPI checkUsername(
      @RequestParam(value = "username", defaultValue = "") String username) {
    if (StringUtil.isEmpty(username)) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, RegisterCheckConstants
          .USERNAME_CANNOT_BE_EMPTY);
    }

    if (!StringUtil.isUsername(username)) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, RegisterCheckConstants
          .USERNAME_IS_UNVALID);
    }

    return new StandardResponseAPI();
  }

  @RequestMapping(value = "check/email/", method = RequestMethod.POST)
  public StandardResponseAPI checkEmail() {
    // TODO
    return new StandardResponseAPI();
  }

  @RequestMapping(value = "check/telephone/", method = RequestMethod.POST)
  public StandardResponseAPI checkTelephone() {
    // TODO
    return new StandardResponseAPI();
  }
}
