package com.zuozuo.service.user;

import com.zuozuo.model.session.SessionInfo;
import com.zuozuo.model.user.LoginCheckResult;
import com.zuozuo.model.user.LoginUser;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by bug on 16/1/8.
 */
public interface ISessionManager {
  int REMEMBER_COOKIE_AGE = 1209600;
  int COOKIE_AGE = 86400;

  public void saveSession(LoginUser loginUser);

  public void saveSessionAndSetCookie(LoginUser loginUser, HttpServletResponse response);
}
