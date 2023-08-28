package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
	
	 Account findByEmailid(String emailid);

}
