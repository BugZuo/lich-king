package com.zuozuo.views.home.api;

import com.zuozuo.check.constants.CheckConstants;
import com.zuozuo.common.StringUtil;
import com.zuozuo.common.web.APIStatus;
import com.zuozuo.common.web.StandardResponseAPI;

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
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, CheckConstants
          .USERNAME_CANNOT_BE_EMPTY);
    }

    if (!StringUtil.isUsername(username)) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, CheckConstants.USERNAME_IS_UNVALID);
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
