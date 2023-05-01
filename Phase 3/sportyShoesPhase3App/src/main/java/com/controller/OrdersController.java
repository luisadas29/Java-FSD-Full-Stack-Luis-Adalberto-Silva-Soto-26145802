package com.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Category;
import com.bean.Login;
import com.bean.Orders;
import com.bean.Product;
import com.service.OrdersService;
import com.service.ProductService;

@Controller
public class OrdersController {
	
	@Autowired
	ProductService productService;
	@Autowired
	OrdersService ordersService;
	
	
	@RequestMapping(value = "/ordersReports",method = RequestMethod.GET)
	public String viewOrders(Model rr, Orders oo) {
		List<Orders> listOfOrders = ordersService.viewAllOrderDetails();
		System.out.println(listOfOrders.toString());
		rr.addAttribute("orders", listOfOrders);
        //rr.addAttribute("orders",oo);
		return "ordersReports";
	}
	
	@RequestMapping(value = "placeOrder/{pid}")
	public String placeOrder(Model mm,@PathVariable("pid") int pid,HttpSession x,Orders order) {
		System.out.println("Pid is "+pid);
		String emailid = (String)x.getAttribute("emailid");
		mm.addAttribute("orders", order);
		order.setEmailID(emailid);
		order.setOrderPlaced(LocalDate.now());
		order.setProductID(pid);
		order.setQuantityOfProducts(1);
		String result = ordersService.placeOrder(order);
		productService.decrementQty(pid);
		List<Product> listOfProducts = productService.findAllProducts();
		mm.addAttribute("products", listOfProducts);
		mm.addAttribute("msg", result);
		mm.addAttribute("orders",order);
		return "viewProductsByCustomer";
	}	
	
	@RequestMapping(value = "/ordersByDate",method = RequestMethod.POST)
	public String viewOrdersDate(Model rr, Orders oo) {
	
		//System.out.println(l.toString());
		//List<Orders> listOfOrders = ordersService.viewAllOrderDetails();
		//List<Orders> temp = new ArrayList<Orders>();
		
		List <Orders> result = ordersService.findAllByID(oo.getOrderPlaced());
		
		//System.out.println("Test: " + l.toString());
		//String r = l.toString();
		//List<Orders> listOfOrders = ordersService.filterByDate(l);
		//List<Orders> listOfOrders = ordersService.viewAllOrderDetails();
		rr.addAttribute("orders", oo);
		rr.addAttribute("orders",result);
		return "viewOrdersDate";
	}
	
	@RequestMapping(value = "/ordersByDate",method = RequestMethod.GET)
    public String openViewOrdersDate(Model rr, Orders oo) {
		
		//LocalDate l=oo.getOrderPlaced();
		//List <Orders> result = ordersService.findAllByID(l);
		
		//LocalDate l = oo.getOrderPlaced();
		//String r = l.toString();
		//System.out.println("Test: " + l.toString());
		//List<Orders> listOfOrders = ordersService.filterByDate(l);
		//List<Orders> listOfOrders = ordersService.viewAllOrderDetails();
		rr.addAttribute("orders", oo);
		//rr.addAttribute("orders",result);
		return "ordersByDate";
	}
	
	@RequestMapping(value = "/ordersByCategory",method = RequestMethod.GET)
    public String openViewOrdersProduct(Model rr, Product product) {
		
		//Product product = productService.findProductById(pid);
		//List <Orders> result = ordersService.viewProductCategories(pp);
		rr.addAttribute("product", product);
		//rr.addAttribute("orders",result);
		return "ordersByCategory";
	}
	
	@RequestMapping(value = "/ordersByCategory",method = RequestMethod.POST)
    public String ViewOrdersProduct(Model rr, Product product) {
		//List <Orders> result = ordersService.viewPr;
		rr.addAttribute("product", product);
		//rr.addAttribute("orders", result);
		return "openOrdersCategory";
	}
	
	//@RequestMapping(value = "/viewOrdersDate",method = RequestMethod.GET)
 //   public String ViewOrdersProduct1(@PathVariable("pid") int pid,Model rr) {
	//	Product product = productService.findProductById(pid);
		//rr.addAttribute("product", product);
		//rr.addAttribute("orders", result);
		//return "viewOrdersDate";
	//}
	
	@RequestMapping(value = "/openOrdersCategory/{pid}",method = RequestMethod.GET)
	public String openUpdateForm(@PathVariable("pid") int pid, Model mm) {  
		Product product = productService.findProductById(pid);
		List <Orders> result = ordersService.viewProductCategories(product);
		mm.addAttribute("product", product);		// store product object with name product 
		mm.addAttribute("orders",result);
		return "viewOrdersDate";
	}
}
	
	
	
	//@RequestMapping(value = "/viewOrdersDate",method = RequestMethod.GET)
	//public String viewOrdersDateD(Model rr, Orders oo) {
		// rr.addAttribute("orders", oo);
		 //LocalDate l = oo.getOrderPlaced();
		 //System.out.println("Test: " + l.toString());
		 //String r = l.toString();
	     // List<Orders> listOfOrders = ordersService.viewAllOrderDetails();
			//rr.addAttribute("orders", oo);
			//LocalDate l = oo.getOrderPlaced();
			//System.out.println("Test: " + l.toString());
			//rr.addAttribute("orders", listOfOrders);
		//return "viewOrdersDate";
	//}
	
	//@RequestMapping(value = "/viewOrdersDate",method = RequestMethod.GET)
	//public String openSearchUsers(Model rr, Orders oo) {
		//rr.addAttribute("orders",oo);
		//return "ordersByDate";

	//}
	
	//@RequestMapping(value = "/ordersByDate",method = RequestMethod.POST)
	//public String ordersByDate(Model rr, Orders oo) {
		//List<Orders> listOfOrders = ordersService.viewAllOrderDetails();
		//rr.addAttribute("orders", listOfOrders);
		//return "viewOrdersDate";
	//}

