package com.cxz.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.cxz.springboot.bean.Person;

/**
 * SpringBoot单元测试
 * 可以直接使用自动注入的功能
 * @author 22527
 *
 */
@SpringBootTest
class ApplicationTests {

	@Autowired
	Person person;
	@Autowired
	ApplicationContext ioc;
	
	@Test
	void contextLoads() {
		System.out.println(person);
	}
	
	@Test
	void testHelloService() {
		System.out.println(ioc.containsBean("helloService"));;
		System.out.println(ioc.containsBean("helloService2"));;
	}
}
