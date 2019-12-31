package com.cxz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
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
	 * 
	 * @param userName 用户名
	 * @param book_id  书的id
	 * @param count    买的书的数量
	 * @throws InterruptedException
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void checkout(String userName, String book_id, int count) {

		// 第一步：bookDao查询书的价格
		// 第二步：accountDao账户扣钱
		// 第三步：图书库存减少
		double price = bookDao.SelectPrice(book_id);
		accountDao.updateBalance(userName, price * count);
		bookStockDao.updateStokc(book_id, count);
		int i = 1 / 0;
		try {
			Thread.sleep(4 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 用于测试事务的隔离级别
	 */
	@Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
	public double getPrice(String book_id) {
		return bookDao.SelectPrice(book_id);
	}
	
	/**
	 * 修改价格
	 * @param book_id
	 * @param price
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public void updatePrice(String book_id, double price) {
		bookDao.updatePrice(book_id, price);
		int i = 10 / 0;
	}
}
