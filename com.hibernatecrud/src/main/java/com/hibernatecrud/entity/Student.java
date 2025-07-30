package com.hibernatecrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private String degree;
	private String departmentl;
	
	public Student() {
		
	}
	
	public Student(int id, String name, String surname, String degree, String departmentl) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.degree = degree;
		this.departmentl = departmentl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDepartmentl() {
		return departmentl;
	}
	public void setDepartmentl(String departmentl) {
		this.departmentl = departmentl;
	}

	
}
