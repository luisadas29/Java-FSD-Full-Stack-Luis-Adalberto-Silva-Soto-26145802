package com.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Login {
	@Id
	private String emailid;
	private String password;
	private String typeOfUser;
	@OneToMany
	@JoinColumn(name="emailID")
	private List<Orders> listOfOrders;
	
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	@Override
	public String toString() {
		return "Login [emailid=" + emailid + ", password=" + password + ", typeOfUser=" + typeOfUser + "]";
	}
	

}
