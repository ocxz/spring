package com.cxz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	/**
	 * 用于查询图书的价格
	 * @param book_id
	 * @return
	 */
	public double SelectPrice(String book_id) {
		String sql = "SELECT price FROM book WHERE book_id=?";
		return jdbcTemplate.queryForObject(sql, Double.class, book_id);
	}
}
