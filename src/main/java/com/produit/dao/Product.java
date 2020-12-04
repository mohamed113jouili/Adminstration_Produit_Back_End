package com.produit.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
public class Product  {
	
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long id;

	private String name;

	private String description;

	private double price;

	private int availableStock;


	  @ManyToOne(fetch = FetchType.LAZY)
	  
	  @JoinTable(name = "join_categoryproduct_product", joinColumns = @JoinColumn(name =
	  "product_id"), inverseJoinColumns = @JoinColumn(name =
	  "category_product_id"))
	 

	private CategoryProduct categoryProduct;
	  
	  
	  

}
