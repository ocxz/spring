package com.cxz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cxz.Servlet.BookServlet;

@ContextConfiguration(locations="classpath:applicationContext2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class IOCSprintTest03 {

	@Autowired
	BookServlet bookservlt;
	/**
	 * 使用spring-test进行单元测试
	 */
	@Test
	public void test() {
		System.out.println(bookservlt);
		bookservlt.doGet();
	}
}
