package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.bean.Person;

public class IOCTest02 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext3.xml");
	
	@Test
	public void test1() {
		
		Person p1 = ioc.getBean("person01", Person.class);
		Person p2 = ioc.getBean("person02", Person.class);
		System.out.println(p1);
		System.out.println(p2);
	}
	
	/**
	 * bean之间的依赖
	 */
	@Test
	public void test2() {
		
	}
}
