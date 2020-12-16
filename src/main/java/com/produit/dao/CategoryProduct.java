package com.produit.dao;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.produit.web.exception.Helper;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "categoryProduct")
@Table(name = "category_product",
uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }, 
name = "cap_name") })

public class CategoryProduct implements Comparable<CategoryProduct> {

	@Getter
	@Setter
	@Id
	@GeneratedValue
	@Column(name = "category_product_id")
	private Long id;

	@Getter
	@Setter
	@Size(min = 3, max = 10, message = Helper.MESSAGE_EXCEPTION_SIZE)
	@NotEmpty(message = Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	private String name;

	@Getter
	@Setter
	//@Size(min = 5, max = 1000, message = Helper.MESSAGE_EXCEPTION_LENGTCH)
	//@NotEmpty(message = Helper.MESSAGE_EXCEPTION_NOT_EMPTY)
	private String description;

	// here ignore getter fixed problem
	// "com.fasterxml.jackson.databind.ser.BeanSerializer.serialize..."
	@Setter
	@OneToMany(mappedBy = "categoryProduct", cascade = CascadeType.ALL)
	private List<Product> products;

	
	// for sort
	@Override
	public int compareTo(CategoryProduct o) {
		return id.compareTo(o.getId());
	}

}
