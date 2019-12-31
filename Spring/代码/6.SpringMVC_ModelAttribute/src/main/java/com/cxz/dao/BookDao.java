package com.cxz.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cxz.bean.Book;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 根据id，从数据库中查找图书，并返回
	 * @param id
	 * @return
	 */
	public Book getBook(int id) {

		String sql = "SELECT bookId,bookName,author,price,stock,sales FROM bookinfo WHERE bookId=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);

	}

	/**
	 * 根据book对象，全字段更新book
	 * @param book
	 * @return
	 */
	public int updateBook(Book book) {
		String sql = "UPDATE bookinfo SET bookId=?, SET bookName=?, SET author=?, SET price=?, SET stock=?\r\n" + 
				",SET sales? WHERE bookId=?";
		return jdbcTemplate.update(sql, book.getBookId(), book.getBookName(),
				book.getAuthor(), book.getPrice(), book.getStock(), book.getSales());
	}
}
