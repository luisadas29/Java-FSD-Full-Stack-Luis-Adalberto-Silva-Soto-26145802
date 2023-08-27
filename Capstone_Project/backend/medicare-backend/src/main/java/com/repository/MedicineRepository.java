package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicare.Medicine;


@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
	
	 List<Medicine> findByNameContainingIgnoreCase(String name);
	
}

