package com.studentmanagement.dao;


import org.hibernate.*;

import com.studentmanagement.entities.Student;


public class StudentDAO {
	
    public void saveStudent(Student student) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        tx.commit();
        session.close();
    }

    public Student getStudentById(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public void updateStudent(Student student) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(student);
        tx.commit();
        session.close();
    }

    public void deleteStudent(Student student) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(student);
        tx.commit();
        session.close();
    }
}
