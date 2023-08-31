package com.medicare;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderid;
	private String emailid;
	 @ManyToOne
	    @JoinColumn(name="accno")
	    private Account account;

	 @Column(columnDefinition = "TEXT")
	    private String orderItemStrings;
	 
	 private float totalCost;
	 @Temporal(TemporalType.TIMESTAMP)
	    private Date orderDate;
	 
	 
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
//	public List<OrderItem> getItems() {
//		return items;
//	}
//	public void setItems(List<OrderItem> items) {
//		this.items = items;
//	}
	public float getTotalCost() {
		return totalCost;
	}
	public String getOrderItemStrings() {
		return orderItemStrings;
	}
	public void setOrderItemStrings(String orderItemsJson) {
		this.orderItemStrings = orderItemsJson;
	}
	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	 
	 
	 
	 
	

}

