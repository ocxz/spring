package com.cxz.bean;

/**
 * 图书bean，对应tx库中的book表
 * 
 * @author 22527
 *
 */
public class Book {

	private String book_id;
	private String book_name;
	private double price;

	public Book() {
	}

	public Book(String book_id, String book_name, double price) {
		this.book_id = book_id;
		this.book_name = book_name;
		this.price = price;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", price=" + price + "]";
	}

}
