package com.flyzfq.lich.biz.service.user;

import com.flyzfq.lich.model.user.LoginUser;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by bug on 16/1/8.
 */
public interface ISessionManager {
  int REMEMBER_COOKIE_AGE = 1209600;
  int COOKIE_AGE = 86400;

  void saveSession(LoginUser loginUser);

  void saveSessionAndSetCookie(LoginUser loginUser, HttpServletResponse response);

  boolean removeSessionAndPurge(String sessionId, HttpServletResponse response);
}
