package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Bank;
public interface Repository extends JpaRepository<Bank,Integer> {

	Object findByName(String name);

	Bank findByPassword(String password);

	


	
	

}
