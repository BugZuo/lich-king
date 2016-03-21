package com.flyzfq.lich.biz.impl.cache;

import com.flyzfq.lich.biz.service.cache.ICacheService;
import com.flyzfq.lich.common.data.Xmemcached;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by bug on 16/1/6.
 */
@Service
public class CacheServiceImpl implements ICacheService {

  private static final Logger logger = LoggerFactory.getLogger(ICacheService.class);

  @Autowired
  Xmemcached xmemcached;

  public String get(String key) {
    try {
      return xmemcached.getMemcachedClient().get(key);
    } catch (Exception e) {
      logger.error("Get cache from xmemcached error.", e);
      return "";
    }
  }

  public boolean set(String key, String value) {
    return this.set(key, value, xmemcached.getDefaultTTL());
  }

  public boolean set(String key, String value, int timeout) {
    try {
      return xmemcached.getMemcachedClient().set(key, timeout, value);
    } catch (Exception e) {
      logger.error("Set cache to xmemcached error.", e);
    }
    return false;
  }
}
