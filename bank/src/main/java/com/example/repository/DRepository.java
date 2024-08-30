package com.example.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Deposite;

public interface DRepository extends JpaRepository<Deposite,Integer> {

	List<Deposite> findByAccount(double accountNumber);

	

	

}
