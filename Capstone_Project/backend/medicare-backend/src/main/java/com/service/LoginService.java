package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.Login;
import com.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;
	
	public String signIn(Login login) {

		
Optional<Login> result = loginRepository.findById(login.getEmailid());
		
		if(result.isPresent()) {
			Login ll = result.get();
			if(ll.getPassword().equals(login.getPassword())) {
					
					if(ll.getTypeOfUser().equals("admin")) {
						return "Admin Success";
					}else {
						return "Customer success";
					}
					
			}else {
				return "Password is wrong";
			}
		}else {
			return "EmailId is wrong";
		}
	}
		
	
	
	
	public String signUp(Login login) {
		if (login.getTypeOfUser().contentEquals("admin")) {
			return "Admin Account cannot be created";
		}else {
			Optional<Login> result=loginRepository.findById(login.getEmailid());
			if (result.isPresent()) {
				return "Account already exist";
			}else {
				loginRepository.save(login);
				return "Account created successfully";
			}
			
		}
	}

}
