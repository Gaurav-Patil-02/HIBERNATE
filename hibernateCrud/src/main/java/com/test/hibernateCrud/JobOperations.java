package com.test.hibernateCrud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JobOperations {
	public void insertRecord(Job job) {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(job);
		tx.commit();
		System.out.println("Job category inserted");
		session.close();
		factory.close();
	}
	
	public void updateJob(int jobId,Job job) {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("update Job set job = :j, desc = :d, loc = :l where jobId = :ji ");
		
		query.setParameter("j", job.getJob());
		query.setParameter("d", job.getDesc());
		query.setParameter("l", job.getLoc());
		query.setParameter("ji",jobId);
		
		query.executeUpdate();
		tx.commit();
		System.out.println("Job category Updated");
		
		session.close();
		factory.close();
	}
	
	public void deleteJob(int jobId) {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("delete from Job where jobId = :j");
		
		query.setParameter("j", jobId);
		query.executeUpdate();
		
		tx.commit();
		System.out.println("Job category with Id [" + jobId + "] is Deleted");
		
		session.close();
		factory.close();
		
	}
	
	public void displayJobs() {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("From Job");
		
		List<Job> list = query.list();
		for(Job job : list) {
			System.out.println("Job Id: " + job.getJobId()+
							   ", Job Title :"+job.getJob()+
							   ", Description : " + job.getDesc()+
							   ", Job Location : " + job.getLoc());
		}
		tx.commit();
		
		session.close();
		factory.close();
	}
	public Job getJobById(int jobId) {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
	    Job job = session.get(Job.class, jobId); // Fetch job by ID
	    session.close();
	    return job;
	}
	
	public void showJobsWithEmployees() {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    Query query = session.createQuery("SELECT j FROM Job j JOIN FETCH j.employee");
	    List<Job> jobs = query.list();
	    
	    for (Job job : jobs) {
	        System.out.println("Job Id: " + job.getJobId() + 
	                           ", Title: " + job.getJob() + 
	                           ", Employees: " + job.getEmployee().size());
	        for (Employee emp : job.getEmployee()) {
	            System.out.println("\tEmployee Id: " + emp.getEmpId() + 
	                               ", Name: " + emp.getName());
	        }
	    }
	    
	    tx.commit();
	    session.close();
	    factory.close();
	}
}
