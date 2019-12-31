package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.Servlet.BookServlet;

public class IOCTest02 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");
	@Test
	public void test() {
		BookServlet bookServlet = ioc.getBean("bookServlet", BookServlet.class);
		bookServlet.doGet();
	}
	
	/**
	 * 测试注解方法
	 */
	@Test
	public void test02() {
		
	}
}
