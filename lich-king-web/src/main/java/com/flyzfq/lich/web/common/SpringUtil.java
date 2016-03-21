package com.flyzfq.lich.web.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by bug on 15/11/26.
 */
public class SpringUtil implements ApplicationContextAware {
  private static ApplicationContext app;
  private static final ObjectMapper objectMapper = new ObjectMapper();

  static {
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.app = applicationContext;
  }

  public static ApplicationContext getApp() {
    return app;
  }

  public static Object getBean(String beanName) {
    return app.getBean(beanName);
  }
}
