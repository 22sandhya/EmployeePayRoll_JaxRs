package com.bl.emp.Project_Emp.model;

public class EmpModel {

	public int id, phonenumber;
	public String name, address, department, gender;
	public double salary;

	public EmpModel() {
		super();
	}

	public EmpModel(int id, int phonenumber, String name, String address, String department, String gender,
			double salary) {
		super();
		this.id = id;
		this.phonenumber = phonenumber;
		this.name = name;
		this.address = address;
		this.department = department;
		this.gender = gender;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
