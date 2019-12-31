package com.cxz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.service.BookService;
import com.cxz.service.UserService;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCTest01 {

	@Autowired
	BookService bookService;
	@Autowired
	UserService userService;
	
	/**
	 * 测试，非泛型依赖注入
	 */
	@Test
	public void test() {
		
		bookService.save();
		userService.save();	
	}
	
	/**
	 * 测试，泛型依赖注入
	 */
	@Test
	public void test02() {
		
		bookService.save();
		userService.save();	
	}
}
