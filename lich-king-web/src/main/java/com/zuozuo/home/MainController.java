package com.zuozuo.home;

import com.zuozuo.model.user.BaseUser;
import com.zuozuo.service.cache.ICacheService;
import com.zuozuo.service.user.IUserCoreService;

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
        BaseUser user = userCoreService.getById(1);
        return "mybatis " + user.getUsername() + " " + user.getId();
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
