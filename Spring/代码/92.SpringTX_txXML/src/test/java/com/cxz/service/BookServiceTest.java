package com.cxz.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceTest {

	@Autowired
	BookService bookService;

	@Test
	public void testCheckout() {
		bookService.checkout("李四", "ISBN-001", 2);
	}
}
