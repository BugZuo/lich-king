package com.zuozuo.base;

public class StandardResponseAPI {
	private boolean success;
	private int code;
	private String message;
	private Object data;

	public StandardResponseAPI() {
		this.success = true;
		this.code = APIStatus.SUCCESS.getValue();
	}

	public StandardResponseAPI(APIStatus status) {
		this.code = status.getValue();
		this.success = code == APIStatus.SUCCESS.getValue();
	}

	public StandardResponseAPI(APIStatus status, String message) {
		this.code = status.getValue();
		this.success = code == APIStatus.SUCCESS.getValue();
		this.message = message;
	}

	public StandardResponseAPI(boolean success, APIStatus status, String message, Object data) {
		this.success = success;
		this.code = status.getValue();
		this.message = message;
		this.data = data;
	}

	public static StandardResponseAPI of(Object data) {
		return new StandardResponseAPI(true, APIStatus.SUCCESS, null, data);
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}