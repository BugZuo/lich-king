package com.zuozuo.common.security;

import com.zuozuo.model.session.Authorites.Common;
import com.zuozuo.model.user.BaseUser;
import com.zuozuo.model.user.LoginUser;
import com.zuozuo.service.user.IUserCoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bug on 16/1/9.
 */
public class AuthProvider implements AuthenticationUserDetailsService<Authentication> {

  @Autowired
  private IUserCoreService userCoreService;

  @Override
  public LoginUser loadUserDetails(Authentication authentication) throws UsernameNotFoundException {
    LoginUser loginUser = (LoginUser) authentication.getPrincipal();
    if (loginUser.getUserId() <= 0) {
      authentication.setAuthenticated(false);
      loginUser.setValid(false);
    } else {
      List<GrantedAuthority> authorities = new ArrayList<>();
      authorities.add(new Common());
      loginUser.setAuthorities(authorities);
      BaseUser baseUser = userCoreService.getById(loginUser.getUserId());
      loginUser.setUsername(baseUser.getUsername());
      loginUser.setValid(true);
    }
    return loginUser;
  }
}
