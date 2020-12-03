package com.produit.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name="product")
@Getter
@Setter
public class Product {
	

	@Id  @GeneratedValue
	@Column(name="product_id")
	private Long id;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private int availableStock;
	
	@OneToMany(mappedBy="product",
			  cascade = CascadeType.ALL,
			  orphanRemoval = true
			)
	private List<CategoryProduct> productsCategorys;
	

}
