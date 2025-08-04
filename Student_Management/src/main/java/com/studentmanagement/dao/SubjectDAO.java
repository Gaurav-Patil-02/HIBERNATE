package com.studentmanagement.dao;

import com.studentmanagement.entities.Subject;
import org.hibernate.*;

public class SubjectDAO {
    public void saveSubject(Subject subject) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(subject);
        tx.commit();
        session.close();
    }

    public void updateSubjectName(int id, String newName) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE Subject SET name = :name WHERE id = :id";
        session.createQuery(hql)
               .setParameter("name", newName)
               .setParameter("id", id)
               .executeUpdate();
        tx.commit();
        session.close();
    }

    public void deleteSubjectById(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Subject WHERE id = :id";
        session.createQuery(hql)
               .setParameter("id", id)
               .executeUpdate();
        tx.commit();
        session.close();
    }
}
