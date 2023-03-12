package com.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Students")
public class Students {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int studentid;
	private String studentname;
	private int studentage;
	private Integer tstudentid;
	@ManyToOne
	@JoinColumn(name="tclassid")
	private Classes classes1;
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getStudentage() {
		return studentage;
	}
	public void setStudentage(int studentage) {
		this.studentage = studentage;
	}
	public Integer getTstudentid() {
		return tstudentid;
	}
	public void setTstudentid(Integer tstudentid) {
		this.tstudentid = tstudentid;
	}
	public Classes getClasses() {
		return classes1;
	}
	public void setClasses(Classes classes1) {
		this.classes1 = classes1;
	}
	@Override
	public String toString() {
		return "Students [studentid=" + studentid + ", studentname=" + studentname + ", studentage=" + studentage
				+ ", tstudentid=" + tstudentid + ", classes=" + classes1 + "]";
	}
	

	
	

}
