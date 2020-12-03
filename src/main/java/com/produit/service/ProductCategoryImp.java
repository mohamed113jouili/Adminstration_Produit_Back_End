package com.produit.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produit.dao.CategoryProduct;
import com.produit.dao.CategoryProductRepository;

@Service
@Transactional
public class ProductCategoryImp implements CategoryProductService {

	@Autowired
	CategoryProductRepository categoryproductRepository;

	@Override
	public Optional<CategoryProduct> findOneCategoryProduct(Long id) {
		return categoryproductRepository.findById(id);
	}

	@Override
	public List<CategoryProduct> findAllCategoryProduct() {
		return categoryproductRepository.findAll();
	}

	@Override
	public CategoryProduct saveCategoryProduct(CategoryProduct categoryProduct) {
		return categoryproductRepository.save(categoryProduct);
	}

	@Override
	public CategoryProduct updateCategoryProduct(Long id, CategoryProduct categoryProduct) {
		categoryProduct.setId(id);
		return categoryproductRepository.save(categoryProduct);
	}

	@Override
	public void deleteCategoryProductByid(Long id) {
		categoryproductRepository.deleteById(id);

	}

}
