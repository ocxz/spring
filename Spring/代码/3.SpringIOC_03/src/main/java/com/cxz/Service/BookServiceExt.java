package com.cxz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxz.dao.BookDao;

@Service("bookServiceExt")
public class BookServiceExt extends BookService{
	
	@Autowired
	private BookDao bookDao;
	
	@Override
	public void save() {
		System.out.println("bookServiceExt……");
		bookDao.saveBook();
	}
}
