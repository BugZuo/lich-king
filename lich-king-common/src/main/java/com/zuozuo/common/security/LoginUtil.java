package com.zuozuo.common.security;

import com.zuozuo.model.user.LoginUser;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by bug on 16/1/9.
 */
public class LoginUtil {
  public static LoginUser getLoginUser() {
    LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication();
    if (loginUser == null || loginUser.getUserId() < 1) {
      return null;
    }
    return loginUser;
  }
}
