package com.flyzfq.lich.common.data;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * Created by bug on 16/1/8.
 */
@Component
public class SessionManage implements InitializingBean {
  @Autowired
  private StringRedisTemplate sessionCli;

  private HashOperations<String, String, String> hashCli;
  //  private SetOperations<String, String> setCli;
  private ValueOperations<String, String> valueCli;

  @Override
  public void afterPropertiesSet() throws Exception {
    hashCli = sessionCli.opsForHash();
//    setCli = sessionCli.opsForSet();
    valueCli = sessionCli.opsForValue();
  }

  public String getValue(String key) {
    return valueCli.get(key);
  }

  public String getValue(String namespace, String key) {
    return hashCli.get(namespace, key);
  }

  public void setValue(String key, String value) {
    valueCli.set(key, value);
  }

  public void setValue(String namespace, String key, String value) {
    hashCli.put(namespace, key, value);
  }
}
