package com.dsdeliver.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dsdeliver.dto.OrderDTO;
import com.dsdeliver.dto.ProductDTO;
import com.dsdeliver.entities.Order;
import com.dsdeliver.entities.OrderStatus;
import com.dsdeliver.entities.Product;
import com.dsdeliver.repositories.OrderRepository;
import com.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)

	public List<OrderDTO> findAll() {

		List<Order> list = orderRepository.findOrdersWithProducts();

		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO insert(OrderDTO orderDto) {

		Order order = new Order(null, orderDto.getAddress(), orderDto.getLatitude(), orderDto.getLongitude(),
				Instant.now(), OrderStatus.PENDING);

		for (ProductDTO p : orderDto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}

		order = orderRepository.save(order);
		return new OrderDTO(order);

	}
	
	@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = orderRepository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = orderRepository.save(order);
		
		return new OrderDTO(order);
		
	}
	
	
	
}
