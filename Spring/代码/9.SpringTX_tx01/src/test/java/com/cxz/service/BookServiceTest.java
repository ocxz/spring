package com.cxz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {

	@Autowired
	BookService bookService;
	
	/**
	 * 测试结账，userName：王五
	 * 		book_id：ISBN-002
	 * 		count：3
	 */
	@Test
	public void testCheckout() {
		boolean checkout = bookService.checkout("王五", "ISBN-002", 3);
		System.out.println(checkout);
	}
}
