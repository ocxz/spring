package com.cxz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MulService {

	@Autowired
	private BookService bookService;

	/**
	 * 用于测试事务嵌套时，所需要的事务传播行为
	 */
	@Transactional
	public void mulTx() {
		
		// 第一个事务方法
		// 传播行为可以用来设置，checkout事务方法，是否需要和mulTx事务方法共用一个事务（使用同一条连接）
		bookService.checkout("王五", "ISBN-001", 1);
		
		// 第二个事务方法
		bookService.updatePrice("ISBN-001", 888);
	}
}
