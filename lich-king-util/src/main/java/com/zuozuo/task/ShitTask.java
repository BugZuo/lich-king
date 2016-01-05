package com.zuozuo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by bug on 15/12/30.
 */
@Component
public class ShitTask {

  public ShitTask() {
    System.out.println("-----------------------    Holy Shit!   -----------------------");
  }

  @Scheduled(cron = "0 0 1 * * ?")
  public void shitTask() {
    System.out.println("shit!");
  }
}
