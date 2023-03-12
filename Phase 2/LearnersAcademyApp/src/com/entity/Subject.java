package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int subid;
	private String subjectname;
	private Integer tsud;
	private Integer tsud1;
	
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	@Override
	public String toString() {
		return "Subject [subid=" + subid + ", subjectname=" + subjectname + ", tsud=" + tsud + "]";
	}
	public Integer getTsud() {
		return tsud;
	}
	public void setTsud(Integer tsud) {
		this.tsud = tsud;
	}
	public Integer getTsud1() {
		return tsud1;
	}
	public void setTsud1(Integer tsud1) {
		this.tsud1 = tsud1;
	}
	
	

}
