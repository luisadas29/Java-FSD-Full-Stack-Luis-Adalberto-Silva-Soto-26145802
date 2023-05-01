package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Category;
import com.bean.Product;
import com.service.CategoryService;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping(value="/adminHomepagesP",method =RequestMethod.GET)
	public String back1(Model mm,Product pp) {
		mm.addAttribute("product", pp);
		return "adminHomepage";
	}
	
	@RequestMapping(value="/addProductPage",method =RequestMethod.GET)
	public String openAddProductPage(Model mm,Product pp) {
		mm.addAttribute("product", pp);
		List<Category> listOfCategory = categoryService.findAllCategory();
		mm.addAttribute("category", listOfCategory);
		return "addProduct";
	}
	
		@RequestMapping(value="/storeProductInfo",method =RequestMethod.POST)
		public String storeProductPage(Model mm,Product pp) {
			String temp = productService.storeProduct(pp);
			mm.addAttribute("product", pp);
			mm.addAttribute("msg", temp);
			List<Category> listOfCategory = categoryService.findAllCategory();
			mm.addAttribute("category", listOfCategory);
			return "addProduct";
		
	}
		
		@RequestMapping(value = "/viewProductDetailsByCustomer",method = RequestMethod.GET)
		public String viewProduct(Model mm, Product pp) {
			List<Product> listOfProducts = productService.findAllProducts();
			mm.addAttribute("products", listOfProducts);
			
			return "viewProductsByCustomer";
		}
	
	

}


