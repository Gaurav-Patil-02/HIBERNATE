package com.studentmanagement.dao;


import com.studentmanagement.entities.Instructor;
import org.hibernate.*;
import org.hibernate.query.Query;


public class InstructorDAO {
    public void saveInstructor(Instructor instructor) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(instructor);
        tx.commit();
        session.close();
    }

    public Instructor getInstructorById(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        String hql = "FROM Instructor WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Instructor instructor = (Instructor) query.uniqueResult();
        session.close();
        return instructor;
    }

    public void updateInstructorName(int id, String newName) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE Instructor SET name = :name WHERE id = :id";
        session.createQuery(hql)
               .setParameter("name", newName)
               .setParameter("id", id)
               .executeUpdate();
        tx.commit();
        session.close();
    }

    public void deleteInstructorById(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Instructor WHERE id = :id";
        session.createQuery(hql)
               .setParameter("id", id)
               .executeUpdate();
        tx.commit();
        session.close();
    }

	
}

