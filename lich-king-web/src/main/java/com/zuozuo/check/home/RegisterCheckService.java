package com.zuozuo.check.home;

import com.zuozuo.check.CheckResult;
import com.zuozuo.check.constants.CheckConstants;
import com.zuozuo.common.StringUtil;
import com.zuozuo.forms.RegisterForm;

import org.springframework.stereotype.Component;

/**
 * Created by bug on 16/1/11.
 */
@Component
public class RegisterCheckService {

  public CheckResult checkRegisterForm(RegisterForm form) {
    if (StringUtil.isEmpty(form.getUsername())) {
      return CheckResult.of(CheckConstants.USERNAME_CANNOT_BE_EMPTY);
    }

    if (!StringUtil.isUsername(form.getUsername())) {
      return CheckResult.of(CheckConstants.USERNAME_IS_UNVALID);
    }

    if (!StringUtil.isPhoneNumberValid(form.getTelephone())) {
      return CheckResult.of(CheckConstants.TELEPHOE_IS_UNVALID);
    }

    return new CheckResult();
  }
}
