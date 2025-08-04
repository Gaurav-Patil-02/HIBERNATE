package com.studentmanagement.dao;



import com.studentmanagement.entities.Enrollment;
import org.hibernate.*;


public class EnrollmentDAO {
    public void saveEnrollment(Enrollment enrollment) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(enrollment);
        tx.commit();
        session.close();
    }

    public void updateStatus(int id, String status) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "UPDATE Enrollment SET status = :status WHERE id = :id";
        session.createQuery(hql)
               .setParameter("status", status)
               .setParameter("id", id)
               .executeUpdate();
        tx.commit();
        session.close();
    }

    public void deleteEnrollment(int id) {
        Session session = DBConnection.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "DELETE FROM Enrollment WHERE id = :id";
        session.createQuery(hql)
               .setParameter("id", id)
               .executeUpdate();
        tx.commit();
        session.close();
    }
}
