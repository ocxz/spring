package com.cxz.bean;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Employee {

	private Integer id;
	@NotBlank
	private String uid;
	@NotBlank
	@Length(min=6,max=18)
	private String lastName;
	@Email(regexp="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$")
	private String email;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern="yyyy-MM-dd")
	@Past
	private Date birthday;
	private Integer gender = 1;
	@JsonIgnore
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
		return "Employee [id=" + id + ", uid=" + uid + ", lastName=" + lastName + ", email=" + email + ", Birthday="
				+ birthday + ", gender=" + gender + ", department=" + department + "]";
	}
}
