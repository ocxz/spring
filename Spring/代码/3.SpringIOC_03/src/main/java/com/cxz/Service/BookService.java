package com.cxz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxz.dao.BookDao;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	
	public void save() {
		System.out.println("Service层将图书保存了");
		bookDao.saveBook();
	}
}
