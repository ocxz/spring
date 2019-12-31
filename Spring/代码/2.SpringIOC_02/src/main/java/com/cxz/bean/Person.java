package com.cxz.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

	private String lastName;
	private Integer age;
	private String gender;
	private String email;
	private Double salary;
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	private Car car;
	private List<Book> books;
	private Map<String, Object> maps;
	private Properties properties;

	public Person(Car car) {
		this.car = car;
		System.out.println("car");
	}

	public Person(Car car, List<Book> books) {
		this.car = car;
		this.books = books;
	}
	
	
	public Person(Car car, Properties properties) {
		this.car = car;
		this.properties = properties;
		System.out.println("car + properties");
	}
	

	public Person(String lastName, Car car) {
		this.lastName = lastName;
		this.car = car;
		
	}

	public Person() {
	}

	public Person(Car car, List<Book> books, Properties properties) {
		this.car = car;
		this.books = books;
		this.properties = properties;
		System.out.println("car + books + properties");
	}
	
	

	public Person(Car car, List<Book> books, Map<String, Object> maps, Properties properties) {
		this.car = car;
		this.books = books;
		this.maps = maps;
		this.properties = properties;
		System.out.println("car + books + maps + properties");
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", email=" + email + ", salary="
				+ salary + ", car=" + car + ", books=" + books + ", maps=" + maps + ", properties=" + properties + "]";
	}

	public Person(String lastName, Integer age, String gender, String email) {
		super();
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		System.out.println("有参构造器被调用");
	}
}
