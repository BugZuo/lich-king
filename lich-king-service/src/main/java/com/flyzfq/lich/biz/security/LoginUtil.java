package com.flyzfq.lich.biz.security;

import com.flyzfq.lich.model.user.LoginUser;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bug on 16/1/9.
 */
public class LoginUtil {
  public static LoginUser getLoginUser() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (!(authentication.getPrincipal() instanceof LoginUser)) {
      return null;
    }
    LoginUser loginUser = (LoginUser) authentication.getPrincipal();
    if (loginUser.getUserId() < 1) {
      return null;
    }
    return loginUser;
  }
}
