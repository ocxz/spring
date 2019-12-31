package com.cxz.bean;

/**
 * 图书库存Bean，对应tx数据库中的book_stock表
 * 
 * @author 22527
 *
 */
public class BookStock {

	private int id;
	private String book_id;
	private int stock;

	public BookStock() {
		super();
	}

	public BookStock(String book_id, int stock) {
		super();
		this.book_id = book_id;
		this.stock = stock;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	

	public void setId(int id) {
		this.id = id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "BookStock [id=" + id + ", book_id=" + book_id + ", stock=" + stock + "]";
	}
}
