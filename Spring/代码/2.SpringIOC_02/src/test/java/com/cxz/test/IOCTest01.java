package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.bean.Book;

public class IOCTest01 {

	ConfigurableApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

	/**
	 * 
	 */
	@Test
	public void test01() {
		System.out.println("容器要关闭了");
		ioc.close();
	}
	
	@Test
	public void test02() {
		Book book = ioc.getBean("book01", Book.class);
		// 
		System.out.println(book);
	}
}
