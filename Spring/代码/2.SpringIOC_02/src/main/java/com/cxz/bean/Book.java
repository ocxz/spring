package com.cxz.bean;

public class Book {

	private String bookName;
	private String author;
	
	public void bookInit() {
		System.out.println("这是图书初始化方法");
	}
	
	public void bookDestory() {
		System.out.println("这是图书的销毁方法");
	}
	
	public Book() {
		System.out.println("book被创建了");
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + "]";
	}
}
