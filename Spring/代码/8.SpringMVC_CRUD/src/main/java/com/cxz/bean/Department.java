package com.cxz.bean;

public class Department {

	private Integer id;
	private String did;
	private String departmentName;
	
	
	
	public Department(String did, String departmentName) {
		super();
		this.did = did;
		this.departmentName = departmentName;
	}
	public Department() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", did=" + did + ", departmentName=" + departmentName + "]";
	}
}
