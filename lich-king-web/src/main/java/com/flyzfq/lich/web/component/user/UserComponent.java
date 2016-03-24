package com.flyzfq.lich.web.component.user;

import com.flyzfq.arthas.base.SafeUtil;
import com.flyzfq.arthas.common.StringUtil;
import com.flyzfq.lich.common.result.CheckResult;
import com.flyzfq.lich.model.user.dto.RegisterInfoDTO;
import com.flyzfq.lich.web.constants.RegisterCheckConstants;
import com.flyzfq.lich.web.forms.RegisterForm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by bug on 16/1/11.
 */
@Component
public class UserComponent {

  public CheckResult checkRegisterForm(RegisterForm form) {
    if (!StringUtil.isUsername(form.getUsername())) {
      return CheckResult.of(RegisterCheckConstants.USERNAME_IS_INVALID);
    }

    if (!StringUtil.isPhoneNumberValid(form.getTelephone())) {
      return CheckResult.of(RegisterCheckConstants.TELEPHOE_IS_INVALID);
    }

    if (StringUtils.isBlank(form.getPassword())) {
      return CheckResult.of(RegisterCheckConstants.PASSWORD_IS_INVALID);
    }

    if (StringUtils.isBlank(form.getRePassword()) || !StringUtils.equals(form.getPassword(), form
        .getRePassword())) {
      return CheckResult.of(RegisterCheckConstants.RE_PASSWORD_IS_INVALID);
    }

    if (!StringUtil.isEmail(form.getEmail())) {
      return CheckResult.of(RegisterCheckConstants.EMAIL_IS_INVALID);

    }
    return CheckResult.of();
  }

  public RegisterInfoDTO create(RegisterForm registerForm) {
    RegisterInfoDTO registerInfoDTO = new RegisterInfoDTO();
    registerInfoDTO.setUsername(registerForm.getUsername());
    registerInfoDTO.setPassword(SafeUtil.getSaltPassword(registerForm.getPassword()));
    registerInfoDTO.setTelephone(registerForm.getTelephone());
    registerInfoDTO.setEmail(registerForm.getEmail());
    registerInfoDTO.setLastName(registerForm.getLastName());
    registerInfoDTO.setFirstName(registerForm.getFirstName());
    return registerInfoDTO;
  }
}
