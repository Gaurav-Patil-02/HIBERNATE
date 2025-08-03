package com.studentmanagement.entities;

import jakarta.persistence.*;

@Entity
public class Enrollment {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Student student;

	@ManyToOne
	private Course course;

	private String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
