package com.cxz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cxz.bean.Book;

@Controller
public class BookController {

	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String index() {
		System.out.println("index");
		return "addBook";
	}

	@RequestMapping(value = "/bookAdd")
	public String addBook(Book book) {
		System.out.println("addBook");
		System.out.println(book);
		return "success";
	}
}
