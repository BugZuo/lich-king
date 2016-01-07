package com.zuozuo.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * Created by bug on 16/1/6.
 */
public class RouterDataSource implements DataSource {

  private final ImmutableMap<DataSource, Integer> dataSourceDelegates;
  private final ImmutableList<DataSource> delegates;

  public RouterDataSource(Map<DataSource, Integer> dataSources) {
    this.dataSourceDelegates = ImmutableMap.<DataSource, Integer>builder().putAll(dataSources).build();
    LinkedList backends = Lists.newLinkedList();
    Iterator iterator = this.dataSourceDelegates.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      DataSource dataSource = (DataSource) entry.getKey();
      Integer weight = (Integer) entry.getValue();
      backends.addAll(Collections.nCopies(weight, dataSource));
    }

    Collections.shuffle(backends);
    this.delegates = ImmutableList.<DataSource>builder().addAll(backends).build();
  }

  protected DataSource getRandomSource() {
    int choice = ThreadLocalRandom.current().nextInt(this.delegates.size());
    return this.delegates.get(choice);
  }

  public Connection getConnection() throws SQLException {
    return getRandomSource().getConnection();
  }

  public Connection getConnection(String username, String password) throws SQLException {
    return getRandomSource().getConnection(username, password);
  }

  public PrintWriter getLogWriter() throws SQLException {
    return getRandomSource().getLogWriter();
  }

  public void setLogWriter(PrintWriter out) throws SQLException {
    Iterator iterator = this.dataSourceDelegates.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      ((DataSource)entry.getKey()).setLogWriter(out);
    }
  }

  public void setLoginTimeout(int seconds) throws SQLException {
    Iterator iterator = this.dataSourceDelegates.entrySet().iterator();

    while (iterator.hasNext()) {
      Map.Entry entry = (Map.Entry) iterator.next();
      ((DataSource)entry.getKey()).setLoginTimeout(seconds);
    }
  }

  public int getLoginTimeout() throws SQLException {
    return getRandomSource().getLoginTimeout();
  }

  public Logger getParentLogger() throws SQLFeatureNotSupportedException {
    return getRandomSource().getParentLogger();
  }

  public <T> T unwrap(Class<T> iface) throws SQLException {
    return getRandomSource().unwrap(iface);
  }

  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return getRandomSource().isWrapperFor(iface);
  }

  public void close() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    for (Map.Entry<DataSource, Integer> dataSourceIntegerEntry : this.dataSourceDelegates.entrySet()) {
      Object ds = dataSourceIntegerEntry.getKey();
      Method close;
      if ((close = ds.getClass().getDeclaredMethod("close")) != null) {
        close.invoke(ds);
      } else if ((close.getClass().getDeclaredMethod("shutdown") != null)) {
        close.invoke(ds);
      }
    }
  }
}
