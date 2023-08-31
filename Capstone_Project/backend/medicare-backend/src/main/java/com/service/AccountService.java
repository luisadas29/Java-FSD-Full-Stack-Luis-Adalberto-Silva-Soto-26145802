package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicare.Account;
import com.medicare.Login;
import com.medicare.Medicine;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount(Account account) {
		accountRepository.save(account);
		return "Account created";
	}
	
	
	  public float getAccountAmount(String email) {
	        Account account = accountRepository.findByEmailid(email);
	        if (account != null) {
	            return account.getAmount();
	        } else {
	            return -1; 
	        }
	    }
	  
	  public float modifyAccountAmount(String email, Float newAmount) {
	        Account account = accountRepository.findByEmailid(email);
	        if (account != null) {
	            account.setAmount(newAmount);
	            accountRepository.save(account);
	            return account.getAmount();
	        } else {
	            return -1; 
	        }
	    }
	  
	  

	    
}
