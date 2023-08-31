package com.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicare.Orders;


public interface OrdersRepository extends JpaRepository<Orders, Long> {
	
    List<Orders> findByemailidOrderByOrderDateDesc(String emailid);
    
    List<Orders> findByAccountOrderByOrderDateDesc(String email);
    
    List<Orders> findByEmailid(String emailid);
}
