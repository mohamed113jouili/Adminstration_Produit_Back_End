package com.produit.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.produit.dao.Product;

import com.produit.service.ProductService;

@CrossOrigin("*")
@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	/*
	 *** find product by id
	 */
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public Optional<Product> getProductById(@PathVariable Long id) {
		return productService.findOneProduct(id);
	}

	/*
	 *** find all product
	 */
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getAllProduct() {
		return productService.findAllProduct();
	}

	/*
	 *** save product
	 */
	@RequestMapping(value = "save/product", method = RequestMethod.POST)
	public Product savePlayer(@Valid @RequestBody Product product) {

		return productService.saveProduct(product);
	}

	/*
	 *** update product
	 */
	@RequestMapping(value = "/update/product/{id}", method = RequestMethod.PUT)
	public Product updatePlayer(@PathVariable Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);

	}

	/*
	 *** delete product by id
	 */
	@RequestMapping(value = "/delete/product/{id}", method = RequestMethod.DELETE)
	public Boolean deletePlayerById(@PathVariable Long id) {
		productService.deleteProductByid(id);
		return true;
	}

}
