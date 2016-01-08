package com.zuozuo.views.handsome.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bug on 16/1/7.
 */
@Controller
public class HandSomeController {

  @RequestMapping(value = "declare/", method = RequestMethod.GET)
  public String declare() {
    return "handsome/declare";
  }
}
