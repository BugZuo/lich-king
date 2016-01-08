package com.zuozuo.common;

/**
 * Created by bug on 16/1/8.
 */
public class SystemUtil {

  public static final String confLocationPrefix = "/zuozuo/conf/";

  public static String getConfDir(String projectName) {
    return confLocationPrefix + projectName;
  }
}
