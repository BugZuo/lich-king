package com.zuozuo.model.user;

/**
 * Created by bug on 16/1/8.
 */
public class LoginCheckResult {
  public final static String LOGIN_SUCCESS = "登录成功!";

  public final static String ERROR_PASSWORD = "密码错误!";

  public final static String UNKNOWN_USERNAME = "不存在的用户名!";

  private boolean success;
  private String message;
  private BaseUser user;

  public LoginCheckResult(boolean success, String message) {
    this.success = success;
    this.message = message;
  }

  public static LoginCheckResult of(String message) {
    return new LoginCheckResult(true, message);
  }

  public static LoginCheckResult failWithMessage(String message) {
    return new LoginCheckResult(false, message);
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public BaseUser getUser() {
    return user;
  }

  public void setUser(BaseUser user) {
    this.user = user;
  }
}
