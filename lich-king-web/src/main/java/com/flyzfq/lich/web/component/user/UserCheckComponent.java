package com.flyzfq.lich.web.component.user;

import com.flyzfq.arthas.common.StringUtil;
import com.flyzfq.lich.common.result.CheckResult;
import com.flyzfq.lich.web.constants.RegisterCheckConstants;
import com.flyzfq.lich.web.forms.RegisterForm;

import org.springframework.stereotype.Component;

/**
 * Created by bug on 16/1/11.
 */
@Component
public class UserCheckComponent {

  public CheckResult checkRegisterForm(RegisterForm form) {
    if (!StringUtil.isUsername(form.getUsername())) {
      return CheckResult.of(RegisterCheckConstants.USERNAME_IS_UNVALID);
    }

    if (!StringUtil.isPhoneNumberValid(form.getTelephone())) {
      return CheckResult.of(RegisterCheckConstants.TELEPHOE_IS_UNVALID);
    }

    return CheckResult.of();
  }
}
