package com.cxz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	@RequestMapping(value="/book", method=RequestMethod.POST)
	public String addBook() {
		System.out.println("添加图书");
		return "success";
	}

	@RequestMapping(value="/book/{bookId}", method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("bookId")String bookId) {
		System.out.println("删除" + bookId + "号图书");
		return "success";
	}

	@RequestMapping(value="/book/{bookId}", method=RequestMethod.PUT)
	public String updateBook(@PathVariable("bookId")String bookId) {
		System.out.println("更新" + bookId + "号图书");
		return "success";
	}

	@RequestMapping(value="/book/{bookId}", method=RequestMethod.GET)
	public String getBook(@PathVariable("bookId")String bookId) {
		System.out.println("查看" + bookId + "号图书");
		return "success";
	}
}
