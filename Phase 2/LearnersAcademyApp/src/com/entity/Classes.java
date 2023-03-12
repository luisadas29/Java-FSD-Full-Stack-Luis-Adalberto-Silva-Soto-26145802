package com.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Classes")
public class Classes {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int classid;
	private String classsection;
	private String classbuilding;
	public Integer tclassid;
	public Integer tclassid1;
	public Integer getTclassid1() {
		return tclassid1;
	}
	public void setTclassid1(Integer tclassid1) {
		this.tclassid1 = tclassid1;
	}

	@OneToMany
	@JoinColumn(name="tstudentid")
	private List <Students> lstofstudents;
	@OneToMany
	@JoinColumn(name="tsud")
	private List <Subject> lstofsubjects;
	@OneToMany
	@JoinColumn(name="ttid")
	private List <Teacher> lstofteachers;
	
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getClasssection() {
		return classsection;
	}
	public void setClasssection(String classsection) {
		this.classsection = classsection;
	}
	public String getClassbuilding() {
		return classbuilding;
	}
	public void setClassbuilding(String classbuilding) {
		this.classbuilding = classbuilding;
	}
	public List<Students> getLstofstudents() {
		return lstofstudents;
	}
	public void setLstofstudents(List<Students> lstofstudents) {
		this.lstofstudents = lstofstudents;
	}
	public List<Subject> getLstofsubjects() {
		return lstofsubjects;
	}
	public void setLstofsubjects(List<Subject> lstofsubjects) {
		this.lstofsubjects = lstofsubjects;
	}
	public List<Teacher> getLstofteachers() {
		return lstofteachers;
	}
	public void setLstofteachers(List<Teacher> lstofteachers) {
		this.lstofteachers = lstofteachers;
	}

	public Integer getTclassid() {
		return tclassid;
	}
	public void setTclassid(Integer tclassid) {
		this.tclassid = tclassid;
	}
	@Override
	public String toString() {
		return "Classes [classid=" + classid + ", classsection=" + classsection + ", classbuilding=" + classbuilding
				+ ", tclassid=" + tclassid + ", lstofstudents=" + lstofstudents + ", lstofsubjects=" + lstofsubjects
				+ ", lstofteachers=" + lstofteachers + "]";
	}
	
	public String studentsMapped() {
		return "Classes [classid=" + classid + ", classsection=" + classsection + ", classbuilding=" + classbuilding
	;
	}
	
	
	
	

}
