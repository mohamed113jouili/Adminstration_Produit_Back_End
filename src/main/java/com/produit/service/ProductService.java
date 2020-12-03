package com.produit.service;

import java.util.List;
import java.util.Optional;

import com.produit.dao.Product;

public interface ProductService {

	public Optional<Product> findOneProduct(Long id);

	public List<Product> findAllProduct();

	public Product saveProduct(Product client);

	public Product updateProduct(Long id,Product client);

	public void deleteProductByid(Long id);
}
