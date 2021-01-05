package com.dsdeliver.service;

import java.util.List;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsdeliver.dto.OrderDTO;
import com.dsdeliver.dto.ProductDTO;
import com.dsdeliver.entities.Order;
import com.dsdeliver.entities.Product;
import com.dsdeliver.repositories.OrderRepository;
import com.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	
	@Transactional(readOnly = true)
	
	public List<OrderDTO> findAll(){
		
		List<Order> list = orderRepository.findOrdersWithProducts();
		
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}


}
