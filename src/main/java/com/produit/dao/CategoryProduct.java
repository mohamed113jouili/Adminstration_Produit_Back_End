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

@Entity(name = "categoryProduct")
public class CategoryProduct {

	@Getter
	@Setter
	@Id
	@GeneratedValue
	@Column(name = "category_product_id")
	private Long id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

	// here ignore getter fixed problem
	// "com.fasterxml.jackson.databind.ser.BeanSerializer.serialize..."
	@Setter
	@OneToMany(mappedBy = "categoryProduct", cascade = CascadeType.ALL)
	private List<Product> products;

}
