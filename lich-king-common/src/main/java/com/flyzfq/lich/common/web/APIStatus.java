package com.flyzfq.lich.common.web;

/**
 * Created by bug on 16/1/11.
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