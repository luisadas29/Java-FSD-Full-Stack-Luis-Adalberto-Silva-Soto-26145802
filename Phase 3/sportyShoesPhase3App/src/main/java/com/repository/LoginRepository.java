package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;            
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.bean.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login,String>{
	
	@Query("select l from Login l where l.emailid = :emailid and l.password = :password and l.typeOfUser = :typeOfUser")
	public Login signin(@Param("emailid") String emailid,
			@Param("password") String password,
		@Param ("typeOfUser") String typeofuser);
	

}
