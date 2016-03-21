package com.flyzfq.lich.common.result;

import java.util.List;

/**
 * Created by bug on 16/3/18.
 */
public class BaseResult<T> {
  private boolean success;
  private int code;
  private String message;
  private T result;
  private List<T> results;

  public BaseResult(boolean success, int code, String message, T result) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.result = result;
  }

  public BaseResult(boolean success, int code, String message, List<T> results) {
    this.success = success;
    this.code = code;
    this.message = message;
    this.results = results;
  }

  public BaseResult(T result) {
    this.result = result;
    this.success = true;
    this.code = BaseResultCode.SUCCESS.getCode();
  }

  public BaseResult(List<T> results) {
    this.results = results;
    this.success = true;
    this.code = BaseResultCode.SUCCESS.getCode();
  }

  private BaseResult(String message, int code) {
    this.message = message;
    this.code = code;
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

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

  public List<T> getResults() {
    return results;
  }

  public void setResults(List<T> results) {
    this.results = results;
  }

  public static BaseResult of(String message, int code) {
    return new BaseResult(message, code);
  }

  public static BaseResult of(BaseResultCode baseResultCode) {
    return of(baseResultCode.getMessage(), baseResultCode.getCode());
  }
}
