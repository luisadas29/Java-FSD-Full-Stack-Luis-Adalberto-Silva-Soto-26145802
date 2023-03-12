package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int tid;
	private String tname;
	private int age;
	private Integer ttid;
	@OneToMany
	@JoinColumn(name="tsud1")
	private List <Subject> lstofsubjects;
	@OneToMany
	@JoinColumn(name="tclassid1")
	private List <Classes> lstofclasses;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public List<Subject> getLstofsubjects() {
		return lstofsubjects;
	}
	public void setLstofsubjects(List<Subject> lstofsubjects) {
		this.lstofsubjects = lstofsubjects;
	}
	public List<Classes> getLstofclasses() {
		return lstofclasses;
	}
	public void setLstofclasses(List<Classes> lstofclasses) {
		this.lstofclasses = lstofclasses;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Integer getTtid() {
		return ttid;
	}
	public void setTtid(Integer ttid) {
		this.ttid = ttid;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", age=" + age + ", ttid=" + ttid + ", lstofsubjects="
				+ lstofsubjects + ", lstofclasses=" + lstofclasses + "]";
	}
	
	

}
