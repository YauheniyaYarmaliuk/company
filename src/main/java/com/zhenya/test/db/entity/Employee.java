package com.zhenya.test.db.entity;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private int id;
	private int deptId;
	private String name;
	private String surname;
	private String patronymic;
	private Date birth;
	private int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptid) {
		this.deptId = deptid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Employee - Id: " + id + ", id department: " + deptId + ", Name: " + name + ", Surname: " + surname
				+ ", Patronymic: " + patronymic + ", Birth: " + birth + ", Salary " + salary;
	}

}