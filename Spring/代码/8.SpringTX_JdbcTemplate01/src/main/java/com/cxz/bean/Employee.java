package com.cxz.bean;

public class Employee {

	private int employeedId;
	private String employeedName;
	private double salary;

	public Employee() {
	}

	public Employee(String employeedName, double salary) {
		this.employeedName = employeedName;
		this.salary = salary;
	}

	public Employee(int employeedId, String employeedName, double salary) {
		this.employeedId = employeedId;
		this.employeedName = employeedName;
		this.salary = salary;
	}

	public int getEmployeedId() {
		return employeedId;
	}

	public void setEmployeedId(int employeedId) {
		this.employeedId = employeedId;
	}

	public String getEmployeedName() {
		return employeedName;
	}

	public void setEmployeedName(String employeedName) {
		this.employeedName = employeedName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeedId=" + employeedId + ", employeedName=" + employeedName + ", salary=" + salary + "]";
	}

}
