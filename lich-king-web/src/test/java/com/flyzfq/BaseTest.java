package com.flyzfq;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by bug on 15/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:src/test/spring-test.xml"})  // Error Format
@ContextConfiguration({"classpath*:src/test/spring-test.xml"}) // Right Format
//@ContextConfiguration({"file:src/test/spring-test.xml"}) // Right Format
public class BaseTest {
}
