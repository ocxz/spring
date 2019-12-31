package com.cxz.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("prototype")
public class BookDao {

	public void saveBook() {
		System.out.println("Dao层将图书保存了");
	}
}
