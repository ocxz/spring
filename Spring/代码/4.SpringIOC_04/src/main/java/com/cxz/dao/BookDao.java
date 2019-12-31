package com.cxz.dao;

import org.springframework.stereotype.Repository;

import com.cxz.bean.Book;

@Repository
public class BookDao extends BaseDao<Book>{

	@Override
	public void save() {
		
		System.out.println("BookDao-->保存图书");
	}
}
