package com.test.hibernateCrud;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="job_details")
public class Job {
	
	@Id
	@Column(name="job_id")
	private int jobId;
	
	private String job;
	
	@Column(name="job_desc")
	private String desc;
	private String loc;
	
	@OneToMany(mappedBy = "job")
	private List<Employee> employee = new ArrayList();
	
	public Job() {
		super();
	}
	public Job(int jobId,String job, String desc, String loc) {
		super();
		this.jobId = jobId;
		this.job = job;
		this.desc = desc;
		this.loc = loc;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", job=" + job + ", desc=" + desc + ", loc=" + loc + "]";
	}
	
	
	
}
