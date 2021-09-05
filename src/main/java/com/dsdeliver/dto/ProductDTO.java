package com.dsdeliver.dto;

import java.io.Serializable;

import com.dsdeliver.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
	private Double price;
	private String description;
	private String imageUri;

	public ProductDTO(Product entity) {

		this.id = entity.getId();
		this.name = entity.getName();
		;
		this.price = entity.getPrice();
		this.description = entity.getDescription();
		this.imageUri = entity.getImageUri();
	}

}
