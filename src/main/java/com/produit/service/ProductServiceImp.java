package com.produit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produit.dao.Product;
import com.produit.dao.ProductRepository;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepository productrepository;

	@Override
	public Optional<Product> findOneProduct(Long id) {
		return productrepository.findById(id);
	}

	@Override
	public List<Product> findAllProduct() {
		return productrepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productrepository.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		product.setId(id);
		return productrepository.save(product);
	}

	@Override
	public void deleteProductByid(Long id) {

		productrepository.deleteById(id);
	}

}
