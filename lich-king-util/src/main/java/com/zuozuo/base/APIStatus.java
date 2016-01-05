package com.zuozuo.base;

/**
 * Created by bug on 15/12/30.
 */
public enum APIStatus {
  SUCCESS(1),
  INVALID_PARAM(2),
  INNER_ERROR(5);

  private int value;

  private APIStatus(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}

