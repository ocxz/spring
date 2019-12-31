package com.cxz.bean;

/**
 * Account的bean，对应tx数据库中的account数据表
 * @author 22527
 *
 */
public class Account {
	
	private int id;
	private String userName;
	private double balance;
	public Account() {
		super();
	}
	public Account(String userName, double balance) {
		super();
		this.userName = userName;
		this.balance = balance;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", userName=" + userName + ", balance=" + balance + "]";
	}
	
	
}
