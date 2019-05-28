package com.nt.domain;

public class PersonDetails {
	private int pid;
	private String pname;
	private JobDetails pjob;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public JobDetails getPjob() {
		return pjob;
	}
	public void setPjob(JobDetails pjob) {
		this.pjob = pjob;
	}

}
