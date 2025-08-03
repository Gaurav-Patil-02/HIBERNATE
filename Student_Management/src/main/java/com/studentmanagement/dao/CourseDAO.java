package com.studentmanagement.dao;



import org.hibernate.*;
import com.studentmanagement.entities.Course;


public class CourseDAO {
    public void saveCourse(Course course) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(course);
        tx.commit();
        session.close();
    }

    public Course getCourseById(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    public void updateCourse(Course course) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.merge(course);
        tx.commit();
        session.close();
    }

    public void deleteCourse(Course course) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.remove(course);
        tx.commit();
        session.close();
    }
}
