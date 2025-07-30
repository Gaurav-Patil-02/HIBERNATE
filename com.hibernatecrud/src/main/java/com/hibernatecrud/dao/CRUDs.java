package com.hibernatecrud.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatecrud.entity.Student;


public class CRUDs {
	public Session connectToDB() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		 Session ss = sf.openSession();
		 
		return ss;
		
	}
	
	public void insert(Student student) {
		Session ss = connectToDB();
		Transaction tr = ss.beginTransaction();
		ss.persist(student);
		tr.commit();
		ss.close();
	}
	
	public void update(int id, Student student) {
		Session ss = connectToDB();
		Transaction tr = ss.beginTransaction();
		
		Student updateStudent = ss.get(Student.class, id);
		updateStudent.setName(student.getName());
		updateStudent.setSurname(student.getSurname());
		updateStudent.setDegree(student.getDegree());
		updateStudent.setDepartmentl(student.getDepartmentl());
		
		ss.merge(updateStudent);
		tr.commit();
		ss.close();
	}
	
	public void delete(int id) {
		Session ss = connectToDB();
		Transaction tr = ss.beginTransaction();
		
		Student newStudent = ss.get(Student.class, id);
		System.out.println(newStudent);
		ss.remove(newStudent);
		
		tr.commit();
		ss.close();
	}
}
