package com.cxz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxz.bean.Book;
import com.cxz.dao.BookDao;

@Controller
public class BookController {

	@Autowired
	BookDao bookDao;
	
	@ModelAttribute
	public void fillData(int bookId, Model model) {
		System.out.println("被ModelAttribute注解的方法，用于从数据库读取数据并封装对象" + bookId);
		Book book = bookDao.getBook(bookId);
		System.out.println(book);
		// 将图书对象，保存到请求域中，在将请求交给处理方法处理
		model.addAttribute("book", book);
	}
	
	/**
	 * 
	 * @param book
	 * @return
	 */
	@RequestMapping(value = "/book", method=RequestMethod.PUT)
	public String updateBook(@ModelAttribute("book")Book book) {
		System.out.println(book);
		return "success";
	}
}
