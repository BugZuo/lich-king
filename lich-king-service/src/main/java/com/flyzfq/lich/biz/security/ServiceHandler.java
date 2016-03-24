package com.flyzfq.lich.biz.security;

import com.flyzfq.lich.common.result.BaseResult;
import com.flyzfq.lich.common.result.BaseResultCode;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by bug on 16/3/18.
 */
@Aspect
@Component
public class ServiceHandler {

  private static final Logger logger = LoggerFactory.getLogger(ServiceHandler.class);

  @Pointcut("execution (public * com.flyzfq.lich.biz.impl.*.*(..))")
  public void pointCut() {}

  @Around("pointCut()")
  public Object afterThrowing(ProceedingJoinPoint point) {
    try {
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      System.out.println("* * * * * * * * * * * * * * * * * * * *");
      return point.proceed();
    } catch (Throwable e) {
      logger.error("Error when execute service for " + point.getSignature(), e);
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      System.out.println("# # # # # # # # # # # # # # # # # # # #");
      return BaseResult.of(BaseResultCode.ERROR.getMessage(), BaseResultCode.ERROR.getCode());
    }
  }
}
