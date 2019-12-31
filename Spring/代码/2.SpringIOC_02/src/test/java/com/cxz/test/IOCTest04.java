package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.bean.Person;

public class IOCTest04 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext4.xml");

	/**
	 * 测试SpEL表达式
	 */
	@Test
	public void test() {
		
		Person person = ioc.getBean("person01", Person.class);
		System.out.println(person);
	}
}
