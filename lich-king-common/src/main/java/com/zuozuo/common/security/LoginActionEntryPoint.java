package com.zuozuo.common.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;


/**
 * Created by bug on 16/1/8.
 */
public class LoginActionEntryPoint implements AuthenticationEntryPoint {

  private String loginUrl;

  private static final String API_STATUS_403 = "{\"status:\": 2}"; // 403 资源不可用

  private static final String CONTENT_TYPE = "application/json;charset=UTF-8";

  @Override
  public void commence(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException authException) throws IOException,
      ServletException {
    String uri = request.getRequestURI();
    if (uri.startsWith("/api")) {
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      response.setContentType(CONTENT_TYPE);
      PrintWriter printWriter = response.getWriter();
      printWriter.print(API_STATUS_403);
      printWriter.close();
      return;
    }

    // otherwise go to login page
    response.sendRedirect(loginUrl);
  }

  public void setLoginUrl(String loginUrl) {
    this.loginUrl = loginUrl;
  }
}

