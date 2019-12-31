package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.bean.Person;

public class IOCTest03 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext3.xml");
	/**
	 * 测试自动装配 byName
	 */
	@Test
	public void test() {
		Person person = ioc.getBean("person", Person.class);
		System.out.println(person);
	}
	
	/**
	 * 测试自动装配 byType
	 */
	@Test
	public void test02() {
		Person person = ioc.getBean("person02", Person.class);
		System.out.println(person);
	}
	
	/**
	 * 测试自动装配 constructor
	 */
	@Test
	public void test03() {
		Person person = ioc.getBean("person03", Person.class);
		System.out.println(person.getCar());
		System.out.println(person.getBooks());
		System.out.println(person.getProperties());
	}
}




