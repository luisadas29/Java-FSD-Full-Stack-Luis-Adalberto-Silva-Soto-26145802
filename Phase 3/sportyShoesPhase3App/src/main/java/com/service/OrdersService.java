package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bean.Orders;
import com.bean.Product;
import com.repository.OrdersRepository;
//import com.repository.OrdersRepository1;
import com.repository.ProductRepository;


@Service
public class OrdersService {

	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public String placeOrder(Orders order) {
		ordersRepository.save(order);
		return "Order Placed successfully";
	}
	
	public List<Orders> viewAllOrderDetails() {
		return ordersRepository.findAll();
		
	}
	
	public List<Orders> findAllByID(LocalDate l) {
		//int x=1;
		List<Orders> oo = ordersRepository.findAll();
		Optional<Orders> temp ;
		//ordersRepository.findById(x);
		List<Orders> result = new ArrayList<> ();
		Orders o ;
	    //String b;
		//temp.get();
		//result.add(o);
		//System.out.println(temp.toString());
		//System.out.println(result.toString());
		for (int i=1;i< oo.size();i++) {
			temp = ordersRepository.findById(i);
			o=temp.get();
			LocalDate d = o.getOrderPlaced();
			System.out.println(d.toString());
			//String a = d.toString();
			//String b= l.toString();
			//System.out.println(a);
			//System.out.println(b);
			Integer a = d.compareTo(l);
			if (a.equals(0)) {
				result.add(o);
			}
			//System.out.println(l.toString());

			//result.add(temp1);
			//result.add(kk);
			}
			//if (result.isEmpty()) {
				//System.out.println(" Empty !!!");
			//}//else {
				//System.out.println(result.toString());
				//temp1.addAll(result);
			System.out.println(result.toString());
		return result;
		}
		//List<Orders> result = ordersRepository1.findAll(x, l);
		
	
	
	public List<Orders> viewProductCategories(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		Product u;
		Product p = result.get();		
		List<Orders> oo = ordersRepository.findAll();
		List<Product> temp = productRepository.findAll();
		List<Orders> temp2 = new ArrayList<Orders> ();
		for(int i =1;i <temp.size()+1;i++) {
			Optional<Product> temp3 = productRepository.findById(i);
			u = temp3.get();
			Integer r = u.getPid();
			if (u.getCategoryID().equals(p.getCategoryID())) {
				for (int j=1;j< oo.size();j++) {
					Optional<Orders> temp4 = ordersRepository.findById(j);
					Orders o = temp4.get();
					Integer t = o.getProductID();
					if (t.equals(r)) {
						temp2.add(o);
					}
					
					
				}
			}
		}
				
		return temp2;
		
	}
	

	
	
	//public Orders findOrdersById(int orderID) {
		//Optional<Orders> result = ordersRepository.findById(orderID);
		//if(result.isPresent()) {
			//Orders order = result.get();
			//return order;
		//}else {
			//return null;
		//}
		
	//}
	
	//public List<Orders> filterByDate() {
		//List<Orders> ordersDate = ordersRepository.findByOrderDate(order.getOrdersID(), order.getOrderPlaced(), order.getProductID(), order.getEmailID(), order.getQuantityOfProducts());
        //Set<Orders> orderDate = (Set<Orders>) ordersRepository.findByOrderPlacedIn(order.getOrderPlaced());r
		//return ordersRepositoryDate.findAllByOrderPlaced();
	//}
	
	
		//ArrayList<Orders> temp = (ArrayList<Orders>) ordersRepository.findAll();
		//List<Orders> temp1 ;
		//for (int i =0 ;i < temp.size();i++) {
			//temp[i]
			//if (temp[i].
		//}
		//return ordersRepository.findAll();
	//}
	
	//public Orders ordersByCategory(Orders order) {
		//Optional<Orders> temp = ordersRepository.findById(order.getProductID());
		//if (temp.isPresent()) {
			//Orders o = temp.get();
			//return o;
		//}else {
			//return null;
		//}	
	}
	
