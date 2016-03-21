package com.flyzfq.home;

import com.flyzfq.BaseTest;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

/**
 * Created by bug on 15/12/30.
 */
public class EmailTest extends BaseTest {
  @Test
  public void test() {
    JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
    // 设定mail server
    senderImpl.setHost("smtp.163.com");

    // 建立邮件消息
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    // 设置收件人，寄件人 用数组发送多个邮件
    // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
    // mailMessage.setTo(array);
    mailMessage.setTo("flyzfq@163.com");
    mailMessage.setFrom("fenqiang.zuo@duitang.com");
    mailMessage.setSubject(" 测试简单文本邮件发送！");
    mailMessage.setText(" 测试我的简单邮件发送机制！！");

    senderImpl.setUsername("fenqiang.zuo"); // 根据自己的情况,设置username
    senderImpl.setPassword("asd123456."); // 根据自己的情况, 设置password

    Properties prop = new Properties();
//    prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
    prop.put("mail.smtp.timeout", "25000");
    senderImpl.setJavaMailProperties(prop);
    // 发送邮件
    senderImpl.send(mailMessage);

    System.out.println(" 邮件发送成功.. ");
  }
}
