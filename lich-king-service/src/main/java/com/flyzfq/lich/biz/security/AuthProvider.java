package com.flyzfq.lich.biz.security;

import com.flyzfq.lich.biz.service.user.IUserCoreService;
import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.model.session.Authorites.Common;
import com.flyzfq.lich.model.user.BaseUser;
import com.flyzfq.lich.model.user.LoginUser;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;

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
      BaseResult<BaseUserDTO> result = userCoreService.getById(loginUser.getUserId());
      if (result != null && result.isSuccess()) {
        loginUser.setUsername(result.getResult().getUsername());
        loginUser.setValid(true);
      } else {
        loginUser.setValid(false);
      }

    }
    return loginUser;
  }
}
