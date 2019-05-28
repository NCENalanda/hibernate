package com.nt.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Project {
	private int proid;
	private String proname;
	private List<Programmer> programmers=new ArrayList();
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public List<Programmer> getProgrammers() {
		return programmers;
	}
	public void setProgrammers(List<Programmer> programmers) {
		this.programmers = programmers;
	}

}
