package com.studentmanagement.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.studentmanagement.entities.*;

public class DBConnection {

	public static SessionFactory getSessionFactory() {
		try {
			Configuration cfg = new Configuration().configure();
			cfg.addAnnotatedClass(Student.class);
			cfg.addAnnotatedClass(Course.class);
			cfg.addAnnotatedClass(Department.class);
			cfg.addAnnotatedClass(Instructor.class);
			cfg.addAnnotatedClass(Subject.class);
			cfg.addAnnotatedClass(Enrollment.class);
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SessionFactory initialization failed!");
		}

	}
}
