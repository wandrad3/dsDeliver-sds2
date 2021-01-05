package com.dsdeliver.controllers;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dsdeliver.dto.OrderDTO;
import com.dsdeliver.service.OrderService;



@RequestMapping(value = "/orders")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
		List<OrderDTO> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO orderDto){
		
		orderDto = orderService.insert(orderDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(orderDto.getId()).toUri();
		return ResponseEntity.created(uri).body(orderDto);
		
	}
	
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id){
		OrderDTO orderDto = orderService.setDelivered(id);
		return ResponseEntity.ok().body(orderDto);
		
	}
	
}
