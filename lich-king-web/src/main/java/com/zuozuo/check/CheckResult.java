package com.zuozuo.check;

import java.util.Map;

/**
 * Created by bug on 16/1/11.
 */
public class CheckResult<K, V> {
  private boolean isSuccess;
  private String message;
  private int status;
  private Map<K, V> results;

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Map<K, V> getResults() {
    return results;
  }

  public void setResults(Map<K, V> results) {
    this.results = results;
  }

  public CheckResult() {
    this.isSuccess = true;
  }

  public static CheckResult of(String message) {
    CheckResult checkResult = new CheckResult();
    checkResult.setSuccess(false);
    checkResult.setMessage(message);
    return checkResult;
  }

  public static <K, V> CheckResult of(String message, int status, Map<K, V> results) {
    CheckResult checkResult = new CheckResult();
    checkResult.setSuccess(false);
    checkResult.setMessage(message);
    checkResult.setStatus(status);
    checkResult.setResults(results);
    return checkResult;
  }
}
