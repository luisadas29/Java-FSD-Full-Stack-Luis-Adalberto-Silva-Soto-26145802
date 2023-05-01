package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String open(Model rr, Login tt) {
		rr.addAttribute("login", tt);
		return "index";
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public String signin(Model rr, Login tt, HttpSession x) {
		String h = loginService.signIn(tt);
		System.out.println(h);
		rr.addAttribute("login", tt);
		
		if(h.equals("User logged in Successfully")) {
			x.setAttribute("emailid", tt.getEmailid()); // to store session.
			return "customerHomepage";
		}else if(h.equals("Administrator logged in successfully")) {
			return "adminHomepage";
		}else {
			return "index";
		}
	}
	
	@RequestMapping(value = "/registerCustomer", method = RequestMethod.GET)
	public String openRegisterCustomer(Model rr, Login tt) {
		String h = loginService.signIn(tt);
		System.out.println(h);
		rr.addAttribute("login", tt);
		return "registerCustomer";
	}
	
	
	@RequestMapping(value = "/registerCustomer",method = RequestMethod.POST)
	public String registerCustomer(Model rr, Login tt) {
		String h = loginService.register(tt);
		rr.addAttribute("msg", h);
		rr.addAttribute("login", tt);
		System.out.println(h);

		return "registerCustomer";

	}
	
	@RequestMapping(value = "/viewUsers",method = RequestMethod.GET)
	public String viewUsers(Model rr, Login tt) {
		List<Login> listOfUsers = loginService.viewAllLoginDetails();
		rr.addAttribute("login", listOfUsers);
		return "viewUsers";
	}
	
	@RequestMapping(value = "/adminHomepage",method = RequestMethod.GET)
	public String back(Model rr, Login tt) {
		rr.addAttribute("login", tt);
		return "adminHomepage";
	}
	
	@RequestMapping(value = "/searchUsers",method = RequestMethod.POST)
	public String searchUsers(Model rr, Login tt) {
		String h = loginService.searchUser(tt);
		rr.addAttribute("msg", h);
		rr.addAttribute("login",tt);
		return "searchUsers";

	}
	
	@RequestMapping(value = "/searchUsers",method = RequestMethod.GET)
	public String openSearchUsers(Model rr, Login tt) {
		rr.addAttribute("login",tt);
		return "searchUsers";

	}
}
