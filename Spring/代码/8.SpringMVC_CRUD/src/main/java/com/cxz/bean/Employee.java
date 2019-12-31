package com.cxz.bean;

public class Employee {

	private Integer id;
	private String uid;
	private String lastName;
	private String email;
	private Integer gender = 1;
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String uid) {
		super();
		this.uid = uid;
	}

	public Employee(String uid, String lastName, String email, Integer gender, Department department) {
		super();
		this.uid = uid;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", uid=" + uid + ", lastName=" + lastName + ", email=" + email + ", gender="
				+ gender + ", department=" + department + "]";
	}
}
