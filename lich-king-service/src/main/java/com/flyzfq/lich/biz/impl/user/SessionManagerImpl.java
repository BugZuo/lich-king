package com.flyzfq.lich.biz.impl.user;

import com.flyzfq.arthas.common.StringUtil;
import com.flyzfq.lich.biz.service.user.ISessionManager;
import com.flyzfq.lich.model.user.LoginUser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by bug on 16/1/8.
 */
public class SessionManagerImpl extends AbstractPreAuthenticatedProcessingFilter implements
    ISessionManager, InitializingBean {

  private static final Logger logger = LoggerFactory.getLogger(SessionManagerImpl.class);

  private static ObjectMapper objectMapper = new ObjectMapper();

  @Resource
  private RedisTemplate<String, String> sessionCli; // StringRedisTemplate is its child class


  public static final String SESSION_ID_KEY = "session_id";

  public static final String USER_ID_KEY = "user_id";

  @Override
  public void saveSession(LoginUser loginUser) {
    loginUser.setSessionId(StringUtil.getUniqueId());
    Map<String, Object> sessionInfo = Maps.newHashMap();
    sessionInfo.put("user_id", String.valueOf(loginUser.getUserId()));
    sessionInfo.put("username", loginUser.getUsername());
//    sessionInfo.put("bind_site", loginCheckResult.getUser().getBindSite());
    try {
      String sessionInfoStr = "lich-king:" + objectMapper.writeValueAsString(sessionInfo);
      sessionCli.opsForValue().set(loginUser.getSessionId(), sessionInfoStr, loginUser.getCookieAge(
      ));
    } catch (Exception e) {
      logger.error("Save session error when save session id" + loginUser.getSessionId(), e);
    }
  }

  @Override
  public void saveSessionAndSetCookie(LoginUser loginUser, HttpServletResponse response) {
    this.saveSession(loginUser);
    response.addCookie(
        makeCookie("username", StringUtil.urlEncode(loginUser.getUsername()), loginUser
            .getCookieAge())
    );
    response.addCookie(
        makeCookie("user_id", String.valueOf(loginUser.getUserId()), loginUser.getCookieAge())
    );
    response.addCookie(
        makeCookie("session_id", loginUser.getSessionId(), loginUser.getCookieAge())
    );
  }

  private Cookie makeCookie(String cookieName, String cookieValue, int cookieAge) {
    Cookie cookie = new Cookie(cookieName, cookieValue);
//    cookie.setDomain("/");  TODO 域名设置
    cookie.setPath("/");
    cookie.setMaxAge(cookieAge);
    return cookie;
  }

  @Override
  protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
    LoginUser loginUser = new LoginUser();
    loadSession(loginUser, request);
    if (!loginUser.isValid()) {
      // other operation

      request.setAttribute(SESSION_ID_KEY, loginUser.getSessionId());
    }
    return loginUser;
  }

  @Override
  protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
    return "";
  }

  public boolean removeSessionAndPurge(String sessionId, HttpServletResponse response) {
    if (StringUtils.isBlank(sessionId)) {
      return true;
    } else {
      sessionCli.opsForHash().delete(sessionId);
      response.addCookie(this.purgeCookie("user_id"));
      response.addCookie(this.purgeCookie("username"));
      return true;
    }
  }

  private Cookie purgeCookie(String key) {
    Cookie cookie = new Cookie(key, (String)null);
//    cookie.setDomain("/"); // TODO 域名设置
    cookie.setPath("/");
    cookie.setMaxAge(0);
    return cookie;
  }

  private void loadSession(LoginUser loginUser, HttpServletRequest request) {
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if (SESSION_ID_KEY.equals(cookie.getName())) {
          Map<String, Object> sessionInfo = loadSessionInfoFromRedis(cookie.getValue());
          if (sessionInfo.get(USER_ID_KEY) == null) {
            break;
          }
          long userId = Long.valueOf(String.valueOf(sessionInfo.get(USER_ID_KEY)));
          loginUser.setUserId(userId);
          loginUser.setSessionId(cookie.getValue());
          loginUser.setValid(true);
          return;
        }
      }
    }

    loginUser.setSessionId(StringUtil.getUniqueId());
  }

  private Map<String, Object> loadSessionInfoFromRedis(String key) {
    Map<String, Object> sessionInfo = new HashMap<>();
    String base64msg = getSessionData(key);
    if (StringUtil.isEmpty(base64msg)) {
      return sessionInfo;
    }

    String[] result = base64msg.split(":");
    if (result.length < 2) {
      return sessionInfo;
    }

    int position = base64msg.indexOf(":");
    if (position > 0) {
      try {
        sessionInfo = objectMapper.readValue(base64msg.substring(position + 1), sessionInfo
            .getClass());
        return sessionInfo;
      } catch (IOException e) {
        logger.error("Read Session Info Error.", e);
      }
    }
    return sessionInfo;
  }

  private String getSessionData(String key) {
    return sessionCli.opsForValue().get(key);
  }
}
