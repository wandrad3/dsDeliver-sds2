package com.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsdeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
