package com.flyzfq.lich.common.data;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;

/**
 * Created by bug on 16/1/6.
 */
public class Xmemcached {
  MemcachedClient memcachedClient;
  int defaultTTL;

  public Xmemcached(String url, int defaultTTL) throws IOException {
    MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(AddrUtil
        .getAddresses(url));
    memcachedClient = memcachedClientBuilder.build();
    this.defaultTTL = defaultTTL;
  }

  public MemcachedClient getMemcachedClient() {
    return this.memcachedClient;
  }

  public int getDefaultTTL() {
    return this.defaultTTL;
  }
}
