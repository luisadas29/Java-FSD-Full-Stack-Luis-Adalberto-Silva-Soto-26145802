package com.bean;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;



@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int ordersID;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate orderPlaced;
	private Integer productID;
	private String emailID;
	private int quantityOfProducts;
	
	public int getQuantityOfProducts() {
		return quantityOfProducts;
	}
	public void setQuantityOfProducts(int quantityOfProducts) {
		this.quantityOfProducts = quantityOfProducts;
	}
	public int getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
	}
	public LocalDate getOrderPlaced() {
		return orderPlaced;
	}
	public void setOrderPlaced(LocalDate orderPlaced) {
		this.orderPlaced = orderPlaced;
	}
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	
	@Override
	public String toString() {
		return "Orders [ordersID=" + ordersID + ", orderPlaced=" + orderPlaced + ", productID=" + productID
				+ ", emailID=" + emailID + ", quantityOfProducts=" + quantityOfProducts + "]";
	}
}
