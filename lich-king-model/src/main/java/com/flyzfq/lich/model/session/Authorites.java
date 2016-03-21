package com.flyzfq.lich.model.session;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by bug on 16/1/9.
 */
public class Authorites {

  public static class Common implements GrantedAuthority {
    @Override
    public String getAuthority() {
      return "COMMON_USER";
    }
  }
}
