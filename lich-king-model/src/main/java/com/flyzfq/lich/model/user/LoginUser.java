package com.flyzfq.lich.model.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class LoginUser implements UserDetails {

  private static final long serialVersionUID = 3461043287159250307L;

  private long userId;
  private String username;
  private String sessionId;
  private List<String> bindStatus;
  private int cookieAge;
  private boolean isValid;

  private List<GrantedAuthority> authorities = null;

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public List<String> getBindStatus() {
    return bindStatus;
  }

  public void setBindStatus(List<String> bindStatus) {
    this.bindStatus = bindStatus;
  }

  public int getCookieAge() {
    return cookieAge;
  }

  public void setCookieAge(int cookieAge) {
    this.cookieAge = cookieAge;
  }

  public void setAuthorities(List<GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  public boolean isValid() {
    return isValid;
  }

  public void setValid(boolean valid) {
    isValid = valid;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.authorities;
  }

  @Override
  public String getPassword() {
    return null;
  }

  @Override
  public String getUsername() {
    return this.username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.isValid;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return false;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}