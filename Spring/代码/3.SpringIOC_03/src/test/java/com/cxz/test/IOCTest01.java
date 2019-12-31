package com.cxz.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cxz.dao.BookDao;

public class IOCTest01 {

	ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	/**
	 * 测试通过注解的方式添加组件
	 */
	@Test
	public void test() {
		
		System.out.println("");
		BookDao bookDao = ioc.getBean("bookDao", BookDao.class);
		BookDao bookDao2 = ioc.getBean("bookDao", BookDao.class);
		System.out.println(bookDao == bookDao2);
	}
}
