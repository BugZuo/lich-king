package com.flyzfq.lich.common.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by bug on 15/12/30.
 */
@Component
public class ShitTask {

  private static final Logger logger = LoggerFactory.getLogger(ShitTask.class);

  @Scheduled(cron = "0 0 1 * * ?")
  public void shitTask() {
    logger.info("I'm running the shit task to test the schedule.");
  }
}
