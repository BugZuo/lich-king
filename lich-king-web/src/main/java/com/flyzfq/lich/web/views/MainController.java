package com.flyzfq.lich.web.views;

import com.flyzfq.lich.biz.service.cache.ICacheService;
import com.flyzfq.lich.biz.service.user.IUserCoreService;
import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.model.user.BaseUser;
import com.flyzfq.lich.model.user.dto.BaseUserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by bug on 15/11/25.
 */
@Controller
public class MainController {

  @Autowired
  private IUserCoreService userCoreService;

  @Autowired
  private ICacheService cacheService;

  @RequestMapping(value = "hello/", method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return "hello";
  }

  @RequestMapping(value = "hi/", method = RequestMethod.GET)
  public String hi() {
    return "index";
  }

  @RequestMapping(value = "mybatis/", method = RequestMethod.GET)
  @ResponseBody
  public String mybatis() {
    BaseResult<BaseUserDTO> result = userCoreService.getById(1);
    BaseUserDTO userDTO = result.getResult();
    return "mybatis " + userDTO.getUsername() + " " + userDTO.getId();
  }

  @RequestMapping(value = "xmemcached", method = RequestMethod.GET)
  @ResponseBody
  public String memcache(String way, String key, String value) {
    String result;
    if ("set".equals(way)) {
      if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value)) {
        result = String.valueOf(cacheService.set(key, value));
      } else {
        return "key or value is empty";
      }
    } else {
      if (!StringUtils.isEmpty(key)) {
        result = cacheService.get(key);
      } else {
        return "key is empty!";
      }
    }
    return result;
  }
}
