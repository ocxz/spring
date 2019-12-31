package com.cxz.Servlet;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.cxz.Service.BookService;
import com.cxz.dao.BookDao;

/**
 * 属性的自动注入
 * 
 * @author 22527
 *
 */
@Controller
public class BookServlet {

	@Autowired(required = false)
	@Qualifier("bookServiceExt")
	private BookService bookService;

	@Autowired(required=false)
	public void test(BookDao bookDao, @Qualifier("bookServiceExt")BookService bookService) {
		System.out.println("@Autowired装配的方法，自动将参数装配且自动调用");
		bookDao.saveBook();
		bookService.save();
	}

	public void doGet() {
//		System.out.println("????");
		bookService.save();
	}
}
