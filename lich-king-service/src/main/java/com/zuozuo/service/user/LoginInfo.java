package com.zuozuo.service.user;

import com.zuozuo.model.user.BaseUser;

public class LoginInfo {

	public final static String LOGIN_SUCCESS = "登录成功!";

	public final static String ERROR_PASSWORD = "密码错误!";

	public final static String UNKNOWN_USERNAME = "不存在的用户名!";

	private boolean success;
	private String message;
	private BaseUser user;

	public LoginInfo(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public static LoginInfo of(String message) {
		return new LoginInfo(true, message);
	}

	public static LoginInfo failWithMessage(String message) {
		return new LoginInfo(false, message);
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