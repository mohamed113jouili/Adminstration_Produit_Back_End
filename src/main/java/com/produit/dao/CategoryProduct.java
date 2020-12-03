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

@Entity
@Getter
@Setter
public class CategoryProduct {
	@Id
	@GeneratedValue
	@Column(name = "category_product_id")
	private Long id;

	private String name;

	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "category_product_product", joinColumns = @JoinColumn(name = "category_product_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private Product product;

}
