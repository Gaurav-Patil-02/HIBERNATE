package com.test.hibernateCrud;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class EmpOperations {
	
	public void insertEmp(Employee emp, int jobId) {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Job job = session.get(Job.class, jobId);
	    if (job != null) {
	    	emp.setJob(job);
	        job.getEmployee().add(emp);
	    }
		
		session.save(emp);
		tx.commit();
		
		System.out.println("Employee Hired!");
	}
	
	public void updateEmp(int empId, Employee emp) {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("update Employee set name = :n, salary = :s, hq = :h where empId = :e");
		
		query.setParameter("n", emp.getName());
		query.setParameter("s", emp.getSalary());
		query.setParameter("h", emp.getHq());
		query.setParameter("e", empId);
		
		tx.commit();
		System.out.println("Employee Details Updated Successfuly");
		
	}
	
	public void deleteEmp(int empId) {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("delete from Employee where empId = :e");
		query.setParameter("e", empId);
		
		tx.commit();
		System.out.println("Record Deleted Successfuly");

	
	public void showEmps() {
		SessionFactory factory =  new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Query query = session.createQuery("From Employee");
		
		List<Employee> list = query.list();
		for(Employee emp : list) {
			System.out.println("Employee Id: " + emp.getEmpId()+
					           ", Employee Name :"+emp.getName()+
					           ", Salary:" + emp.getSalary()+
					           ", Highest Qualification: " + emp.getHq());
		}
		tx.commit();
		
		session.close();
		factory.close();
	}
	
	public void showEmployeesWithJobs() {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	    Session session = factory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    Query query = session.createQuery("SELECT e FROM Employee e JOIN FETCH e.job");
	    List<Employee> employees = query.list();
	    
	    for (Employee emp : employees) {
	        System.out.println("Employee Id: " + emp.getEmpId() + 
	                           ", Name: " + emp.getName() + 
	                           ", Job: " + (emp.getJob() != null ? emp.getJob().getJob() : "No Job Assigned"));
	    }
	    
	    tx.commit();
	    session.close();
	    factory.close();
	}

}
