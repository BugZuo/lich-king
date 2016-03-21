package com.flyzfq.lich.web.forms;

public class LoginForm {
  private String username;
  private String password;
  private String validateCode;
  private boolean isRemeber;

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getValidateCode() {
    return validateCode;
  }

  public void setValidateCode(String validateCode) {
    this.validateCode = validateCode;
  }

  public boolean isRemeber() {
    return isRemeber;
  }

  public void setRemeber(boolean remeber) {
    isRemeber = remeber;
  }
}