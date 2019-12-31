package com.cxz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxz.dao.AccountDao;
import com.cxz.dao.BookDao;
import com.cxz.dao.BookStockDao;

@Service
public class BookService {

	@Autowired
	BookDao bookDao;
	@Autowired
	AccountDao accountDao;
	@Autowired
	BookStockDao bookStockDao;
	/**
	 * 结账：传入哪个用户买了哪个书，多少本
	 * @param userName 用户名
	 * @param book_id 书的id
	 * @param count 买的书的数量
	 */
	@Transactional
	public boolean checkout(String userName, String book_id, int count) {
		
		// 第一步：bookDao查询书的价格
		// 第二步：accountDao账户扣钱
		// 第三步：图书库存减少
		try {
			double price = bookDao.SelectPrice(book_id);
			accountDao.updateBalance(userName, price * count);
			bookStockDao.updateStokc(book_id, count);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
