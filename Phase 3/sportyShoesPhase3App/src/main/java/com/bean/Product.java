package com.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int pid;
	private String pName;
	private float price;
	private int quantity;
	private Integer categoryID;
	@Lob
	private String pImage;
	@OneToMany
	@JoinColumn(name="productID")
	private List<Orders> listOfOrders;
	
	public int getPid() {
		return pid;
	}
	public List<Orders> getListOfOrders() {
		return listOfOrders;
	}
	public void setListOfOrders(List<Orders> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
				+ ", categoryID=" + categoryID + ", pImage=" + pImage + ", listOfOrders=" + listOfOrders + "]";
	}
	
	

}
