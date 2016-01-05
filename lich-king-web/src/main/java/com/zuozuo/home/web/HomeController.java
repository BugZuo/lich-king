package com.zuozuo.home.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bug on 15/12/30.
 */
@Controller
public class HomeController {

  @RequestMapping(value = {"/", "index/"}, method = RequestMethod.GET)
  public String home() {
    return "home/main";
  }

  @RequestMapping(value = "upload/", method = RequestMethod.POST)
  public String upload() {
    return "home/upload";
  }
}
