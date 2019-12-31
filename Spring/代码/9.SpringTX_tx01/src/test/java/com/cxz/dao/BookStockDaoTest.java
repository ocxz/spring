package com.cxz.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BookStockDaoTest {

	@Autowired
	BookStockDao bookStockDao;
	
	@Test
	public void testUpdateStokc() {
		System.out.println(bookStockDao.updateStokc("ISBN-002", 3));
	}
}
