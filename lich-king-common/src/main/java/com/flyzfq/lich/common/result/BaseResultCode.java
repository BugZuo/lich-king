package com.flyzfq.lich.common.result;

/**
 * Created by bug on 16/3/18.
 */
public enum BaseResultCode {
  SUCCESS(200, "SUCCESS"),
  NOT_FOUND(404, "NOT_FOUND"),
  ERROR(500, "ERROR");

  private int code;
  private String message;

  BaseResultCode(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
