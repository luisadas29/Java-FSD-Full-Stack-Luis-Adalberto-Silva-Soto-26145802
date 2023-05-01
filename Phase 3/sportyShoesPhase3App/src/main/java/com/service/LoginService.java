package com.service;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public String register(Login login) {
			Optional<Login> temp = loginRepository.findById(login.getEmailid());
			if (temp.isPresent()) {
				return "Email is already in use by a user account, please Login instead";
			}else {
				try {
				loginRepository.save(login);
				}catch(Exception e) {
					System.out.println("There was an issue with the registration, please try again later");
				}
				return " Account created successfully";
			}	
		}	
	
	public String signIn(Login login) {
		
		Login temp2 = loginRepository.signin(login.getEmailid(), login.getPassword(), login.getTypeOfUser());
		if (temp2 == null) {
			return "Account does not exist, please create one";
		}else {
			if (temp2.getTypeOfUser().equalsIgnoreCase("Administrator")) {
				return "Administrator logged in successfully";
			}else {
				return "User logged in Successfully";
			}
		}
	}
	
	public List<Login> viewAllLoginDetails() {
		return loginRepository.findAll();
	
	}
	
	public String searchUser(Login login) {
		Optional<Login> temp1 = loginRepository.findById(login.getEmailid());
		if (temp1.isPresent()) {
			return "Account found ! User with email ID " + login.getEmailid() + " is Registered in the website";
		}else {
			return "Account not found";
		}	
	}
	}	


	