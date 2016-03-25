package com.flyzfq.lich.web.views.home.api;

import com.flyzfq.lich.biz.security.LoginUtil;
import com.flyzfq.lich.biz.service.user.ISessionManager;
import com.flyzfq.lich.biz.service.user.IUserCoreService;
import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.common.web.APIStatus;
import com.flyzfq.lich.common.web.StandardResponseAPI;
import com.flyzfq.lich.model.user.LoginUser;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;
import com.flyzfq.lich.web.assember.user.ApiUserAssemberAdapter;
import com.flyzfq.lich.web.forms.LoginForm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by bug on 15/12/9.
 */
@RestController
@RequestMapping("api/")  // @RestController 继承自Controller,包含了@ResponseBody标签
public class LoginApi {

  @Autowired
  private IUserCoreService userCoreService;

  @Autowired
  private ISessionManager sessionManager;

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
          ApiUserAssemberAdapter.conv(result.getResult()));
    }
    return new StandardResponseAPI(APIStatus.INVALID_PARAM, result.getMessage());
  }

  @RequestMapping(value = "logout/", method = RequestMethod.GET)
  public StandardResponseAPI logOut(
      HttpServletResponse response,
      @CookieValue(value = "session_id", defaultValue = "") String sessionId) {
    LoginUser loginUser = LoginUtil.getLoginUser();
    if (loginUser != null) {
      sessionId = loginUser.getSessionId();
    }

    if (StringUtils.isBlank(sessionId)) {
      return new StandardResponseAPI();
    }
    sessionManager.removeSessionAndPurge(sessionId, response);
    return new StandardResponseAPI();
  }
}
