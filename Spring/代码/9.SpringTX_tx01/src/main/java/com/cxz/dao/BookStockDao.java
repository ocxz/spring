package com.cxz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookStockDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/**
	 * 减去某本书的库存
	 * @param book_id 书的id
	 * @param count 减去库存量
	 * @return
	 */
	public int updateStokc(String book_id, int count) {
		String sql = "UPDATE book_stock SET stock=stock-? WHERE book_id=?";
		return jdbcTemplate.update(sql, count, book_id);
	}
}
