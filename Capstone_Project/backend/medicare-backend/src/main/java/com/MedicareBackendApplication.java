package com;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.medicare.Login;
import com.repository.LoginRepository;

@SpringBootApplication(scanBasePackages ="com")
@EntityScan(basePackages = "com.medicare")
@EnableJpaRepositories(basePackages ="com.repository")

public class MedicareBackendApplication {
	
	@Autowired
	LoginRepository loginRepository;
	
	@PostConstruct
	public void adminAccountCreation( ) {
		Login ll = new Login();
		ll.setEmailid("admin@gmail.com");
		ll.setPassword("admin@123");
		ll.setTypeOfUser("admin");
		loginRepository.save(ll);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MedicareBackendApplication.class, args);
		System.out.println("spring boot backend ready");
	}

}
