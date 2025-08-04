package com.test.hibernateCrud;

import jakarta.persistence.*;

@Entity
@Table(name="employee_details")
public class Employee {



	@Id
	@Column(name="emp_id")
	private int empId;
	private String name;
	private Double salary;
	private String hq;
	
	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;
	
	public Employee() {
		super();
	}


	public Employee(int empId,String name, Double salary, String hq) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.hq = hq;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getSalary() {
		return salary;
	}


	public void setSalary(Double salary) {
		this.salary = salary;
	}


	public String getHq() {
		return hq;
	}


	public void setHq(String hq) {
		this.hq = hq;
	}

	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public Job getJob() {
		return job;
	}


	public void setJob(Job job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "Employee [employee Id = " + empId + "name=" + name + ", salary=" + salary + ", hq=" + hq + "]";
	}
	
	
}
