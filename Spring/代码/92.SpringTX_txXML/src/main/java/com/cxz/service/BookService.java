package com.cxz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cxz.dao.AccountDao;
import com.cxz.dao.BookDao;
import com.cxz.dao.BookStockDao;

@Repository
public class BookService {

	@Autowired
	BookDao bookDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	BookStockDao bookStockDao;

	public void checkout(String userName, String book_id, int count) {

		double price = bookDao.SelectPrice(book_id);
		accountDao.updateBalance(userName, price * count);
		bookStockDao.updateStokc(book_id, count);
		int i = 1 / 0;
	}
}
