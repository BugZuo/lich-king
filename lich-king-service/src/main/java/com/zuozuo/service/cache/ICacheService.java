package com.zuozuo.service.cache;

/**
 * Created by bug on 16/1/6.
 */
public interface ICacheService {
  public String get(String key);

  public boolean set(String key, String value);

  public boolean set(String key, String value, int timeout);
}
