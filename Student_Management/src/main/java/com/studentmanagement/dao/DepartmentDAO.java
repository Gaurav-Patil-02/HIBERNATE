package com.studentmanagement.dao;

import com.studentmanagement.entities.Department;
import org.hibernate.*;


public class DepartmentDAO {
    public void saveDepartment(Department dept) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(dept);
        tx.commit();
        session.close();
    }

    public Department getDepartmentById(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        Department dept = session.get(Department.class, id);
        session.close();
        return dept;
    }

    public void updateDepartment(Department dept) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(dept);
        tx.commit();
        session.close();
    }

    public void deleteDepartment(Department dept) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(dept);
        tx.commit();
        session.close();
    }
}
