package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import com.bean.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public String storeProduct(Product product) {
		try {
			productRepository.save(product);
		}catch(Exception e) {
			System.out.println("There was an issue storing the product, please try again later");
		}
		return "Product was added to the Inventory Succesfully";
	}
	
	public List<Product> findAllProducts(){
		return productRepository.findAll();
	}
	
	public void decrementQty(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			p.setQuantity(p.getQuantity()-1);
			productRepository.saveAndFlush(p);	// like update 
		}
	}

	public Product findProductById(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			return p;
		}else {
			return null;
		}
		
	}

}
