package com.flyzfq.lich.common.result;

/**
 * Created by bug on 16/3/18.
 * 参数检查结果Class 模板
 */
public class CheckResult {
  private boolean hasError;
  private String message;

  private CheckResult() {
    this.hasError = false;
  }

  private CheckResult(String message) {
    this.message = message;
    this.hasError = true;
  }

  public boolean isHasError() {
    return hasError;
  }

  public void setHasError(boolean hasError) {
    this.hasError = hasError;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static CheckResult of(String message) {
    return new CheckResult(message);
  }

  public static CheckResult of() {
    return new CheckResult();
  }
}
