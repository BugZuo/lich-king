package com.flyzfq.lich.common.web;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.List;

/**
 * Created by bug on 16/1/11.
 */
public class StandardResponseAPI {
  private int code;
  private String message;
  private Object data;

  public StandardResponseAPI() {
    this.code = APIStatus.SUCCESS.getValue();
  }

  public StandardResponseAPI(APIStatus status) {
    this.code = status.getValue();
  }

  public StandardResponseAPI(APIStatus status, String message) {
    this(status);
    this.message = message;
  }

  public StandardResponseAPI(APIStatus status, Object data) {
    this(status);
    this.data = data;
  }

  public StandardResponseAPI(APIStatus status, String message, Object data) {
    this(status, message);
    this.data = data;
  }

  public <T> StandardResponseAPI(List<T> objectList, boolean hasMore, int next) {
    this(APIStatus.SUCCESS);
    this.data = Maps.newHashMap(ImmutableMap.of("object_list",
        objectList, "has_more", hasMore, "next", next));
  }

  public static StandardResponseAPI of(Object data) {
    return new StandardResponseAPI(APIStatus.SUCCESS, data);
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