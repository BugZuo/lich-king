package com.flyzfq.lich;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by bug on 15/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:src/test/spring-test.xml"})  // Error Format
//@ContextConfiguration({"classpath*:src/test/spring-test.xml"}) // Right Format
@ContextConfiguration({"file:src/test/spring-test.xml"}) // Right Format
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
    TransactionalTestExecutionListener.class})
@Transactional
@ActiveProfiles("test")
public class BaseTest {
}
