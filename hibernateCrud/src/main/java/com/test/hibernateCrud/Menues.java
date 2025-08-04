package com.test.hibernateCrud;
import java.util.Scanner;

public class Menues {
    public void empMenu() {
    	Employee emp = new Employee();
    	EmpOperations emps = new EmpOperations();
    	JobOperations jobs = new JobOperations();
    	
    	Scanner scan = new Scanner(System.in);
    	
    	while(true) {
    		System.out.println("\nChoose an operation:");
            System.out.println("1. Create new Employee");
            System.out.println("2. Update Employee details");
            System.out.println("3. Delete Employee details");
            System.out.println("4. Show All employes");
            System.out.println("5. Show All employes With thier Jobs");
            System.out.println("6. Return to Main Menu");
            int choice = scan.nextInt();
            scan.nextLine();
            
            switch(choice) {
            	case 1:
            	System.out.println("Enter Employee Id");
            	int empId = scan.nextInt();
            	scan.nextLine();
            	emp.setEmpId(empId);
            	
            	System.out.println("Enter Employee Name");
            	String name = scan.nextLine();
            	emp.setName(name);
            	
            	System.out.println("Enter Highest Qualification");
            	String hq = scan.nextLine();
            	emp.setHq(hq);
            	
            	System.out.println("Enter Salary");
            	Double salary = scan.nextDouble();
            	emp.setSalary(salary);
            	
            	System.out.println("Enter Job ID to assign to Employee");
                int jobId = scan.nextInt();
                scan.nextLine();
            	
                Job job = jobs.getJobById(jobId);
                
                emp.setJob(job);
            	emps.insertEmp(emp, jobId);
            	break;
            	
            	case 2:
            	System.out.println("Enter Id to be Update");
            	int empid = scan.nextInt();
            	scan.nextLine();
            	System.out.println("Enter New Employee Id");
            	int empId1 = scan.nextInt();
            	scan.nextLine();
            	emp.setEmpId(empId1);
            	
            	System.out.println("Enter Employee Name");
            	String name1 = scan.nextLine();
            	emp.setName(name1);
            	
            	System.out.println("Enter Highest Qualification");
            	String hq1 = scan.nextLine();
            	emp.setHq(hq1);
            	
            	System.out.println("Enter Salay");
            	Double salary1 = scan.nextDouble();
            	emp.setSalary(salary1);
            	
            	emps.updateEmp(empid, emp);
            	break;
            	case 3:
            	System.out.println("Enter Emp ID to delete");
            	int empId2 = scan.nextInt();
            	emps.deleteEmp(empId2);
            	break;
            	case 4:
            	emps.showEmps();
            	break;
            	case 5:
            	 emps.showEmployeesWithJobs();
            	    break;
            	case 6:
            	return;
            }
    	}
    }
    
    public void jobMenu() {

    	Job job = new Job();
    	JobOperations jobs = new JobOperations();
    	Scanner scan = new Scanner(System.in);
    	
    	while (true) {
             System.out.println("\nChoose an operation:");
             System.out.println("1. Create new Job Category");
             System.out.println("2. Update Job Category");
             System.out.println("3. Delete Job Category");
             System.out.println("4. Show Job Categories");
             System.out.println("5. Show Job Categories with employes");
             System.out.println("6. Return to Main Menu");
             int choice = scan.nextInt();
             scan.nextLine();
             
             switch(choice){
             case 1:
            	 System.out.println("Enter Job Id");
            	 int jobId = scan.nextInt();
            	 job.setJobId(jobId);
            	 scan.nextLine();
            	 
            	 System.out.println("Enter Job Name");
            	 String jobName = scan.nextLine();
            	 job.setJob(jobName);
            	 
            	 
            	 System.out.println("Enter Job Description");
            	 String desc = scan.nextLine();
            	 job.setDesc(desc);
            	 
            	 System.out.println("Enter Job Location");
            	 String loc = scan.nextLine();
            	 job.setLoc(loc);
            	 
            	  
            	 jobs.insertRecord(job);
 
            	 break;
            	 
             case 2:
            	 System.out.println("Enter Job Id");
            	 int jobId1 = scan.nextInt();
            	 
            	 System.out.println("Enter Job Name");
            	 String jobName1 = scan.nextLine();
            	 job.setJob(jobName1);
            	 scan.nextLine();
            	 
            	 System.out.println("Enter Job Description");
            	 String desc1 = scan.nextLine();
            	 job.setDesc(desc1);
            	 
            	 System.out.println("Enter Job Location");
            	 String loc1 = scan.nextLine();
            	 job.setLoc(loc1);
            	 
            	 jobs.updateJob(jobId1, job);
            	 
            	 break;
            	 
             case 3:
             	System.out.println("Enter Job Id to Delete");
             	int jobId2 = scan.nextInt();
             	
             	jobs.deleteJob(jobId2);
             	break;
             
             case 4:
            	 jobs.displayJobs();
            	 break;
            
             case 5:
            	 jobs.showJobsWithEmployees();
            	    break;
             case 6:
            	 return;
             }  
    	 }
    }
}
