package com.produit.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.produit.web.exception.Helper;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
@Table(name = "product",
uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }, 
name = "pro_name") })
public class Product implements Comparable<Product>  {
	
	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private Long id;

	@Size(min = 3, max = 15, message = Helper.MESSAGE_EXCEPTION_SIZE)
	@NotEmpty(message = Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	private String name;

	@Size(min = 5, max = 100, message = Helper.MESSAGE_EXCEPTION_LENGTCH)
	@NotEmpty(message = Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	private String description;

	private double price;

	private int availableStock;


	  @ManyToOne(fetch = FetchType.LAZY)
	  
	  @JoinTable(name = "join_categoryproduct_product", joinColumns = @JoinColumn(name =
	  "product_id"), inverseJoinColumns = @JoinColumn(name =
	  "category_product_id"))
	 

	private CategoryProduct categoryProduct;


	@Override
	public int compareTo(Product o) {
		return id.compareTo(o.getId());
	}
	  
	  
	  

}
