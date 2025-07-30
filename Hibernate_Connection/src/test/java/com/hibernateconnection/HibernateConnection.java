package com.hibernateconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;



public class HibernateConnection {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Student.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ses = sf.openSession();
		Transaction tr = ses.beginTransaction();
		
		Student student = new Student();
		student.setName("Gaurav");
		student.setMobNo(749902899);
		student.setCity("Dhule");
		
		ses.save(student);
		ses.close();
		
		System.out.println("Data saved!!");
		
		
		

	}

}
