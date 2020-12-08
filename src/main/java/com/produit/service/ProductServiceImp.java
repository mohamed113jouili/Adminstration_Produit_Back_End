package com.produit.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produit.dao.CategoryProductRepository;
import com.produit.dao.Product;
import com.produit.dao.ProductRepository;

@Service
@Transactional
public class ProductServiceImp implements ProductService {

	@Autowired
	ProductRepository productrepository;

	@Autowired
	CategoryProductRepository categoryProductRepository;

	@Override
	public Optional<Product> findOneProduct(Long id) {
		return productrepository.findById(id);
	}

	@Override
	public List<Product> findAllProduct() {
		return productrepository.findAll().stream()
	            .sorted(Comparator.comparingLong(Product::getId))
	            .collect(Collectors.toList());
	}

	@Override
	public Product saveProduct(Product product) {
		Product productt = new Product();
		productt = productrepository.save(product);

		productt.setCategoryProduct(categoryProductRepository.findById(product.getCategoryProduct().getId()).get());

		return productt;
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
