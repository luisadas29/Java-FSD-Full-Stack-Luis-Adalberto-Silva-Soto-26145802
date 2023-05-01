package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Category;
import com.service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping(value="/adminHomepages",method =RequestMethod.GET)
	public String back(Model mm,Category cc) {
		mm.addAttribute("category", cc);
		return "adminHomepage";
	}
	
	@RequestMapping(value="/addCategoryPage",method =RequestMethod.GET)
	public String openAddCategoryPage(Model mm,Category cc) {
		mm.addAttribute("category", cc);
		return "addCategory";
	}
	
		@RequestMapping(value="/storeCategoryInfo",method =RequestMethod.POST)
		public String storeAddCategoryPage(Model mm,Category cc) {
			String temp = categoryService.storeCategory(cc);
			mm.addAttribute("category", cc);
			mm.addAttribute("msg", temp);
			return "addCategory";
		
	}
		
		@RequestMapping(value="/viewCategoryPage",method =RequestMethod.GET)
		public String viewCategories (Model mm,Category cc) {
			List<Category> listOfCategories = categoryService.findAllCategory();
			mm.addAttribute("category", listOfCategories);
			return "viewCategory";
		
	}
	
	

}
