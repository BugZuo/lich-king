package com.flyzfq.lich.web.views.home.api;

import com.flyzfq.lich.biz.service.user.IUserCoreService;
import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.common.web.APIStatus;
import com.flyzfq.lich.common.web.StandardResponseAPI;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;
import com.flyzfq.lich.web.assember.user.UserDTOConverter;
import com.flyzfq.lich.web.forms.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bug on 15/12/9.
 */
@RestController
@RequestMapping("api/")  // @RestController 继承自Controller,包含了@ResponseBody标签
public class LoginApi {

  @Autowired
  private IUserCoreService userCoreService;

  @RequestMapping(value = "login/", method = RequestMethod.POST)
  @ResponseBody
  public StandardResponseAPI login(LoginForm loginForm) {  //
    // 匿名表单绑定，可用@ModelAttribute
    // ("loginForm") LoginForm loginForm指定
    if (null == loginForm) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, "invalid_param");
    }

    if (null == loginForm.getUsername() || "".equals(loginForm.getUsername().trim())) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, "empty username");
    }

    if (null == loginForm.getPassword() || "".equals(loginForm.getPassword().trim())) {
      return new StandardResponseAPI(APIStatus.INVALID_PARAM, "empty password");
    }
    BaseResult<BaseUserDTO> result = userCoreService.validateUsernameAndPassword(
        loginForm.getUsername(), loginForm.getPassword());
    if (result.isSuccess()) {
      return new StandardResponseAPI(APIStatus.SUCCESS, result.getMessage(),
          UserDTOConverter.conv(result.getResult()));
    }
    return new StandardResponseAPI(APIStatus.INVALID_PARAM, result.getMessage());
  }
}
