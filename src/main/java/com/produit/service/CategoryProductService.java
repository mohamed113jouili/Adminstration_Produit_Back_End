package com.produit.service;

import java.util.List;
import java.util.Optional;

import com.produit.dao.CategoryProduct;


public interface CategoryProductService {

	public Optional<CategoryProduct> findOneCategoryProduct(Long id);

	public List<CategoryProduct> findAllCategoryProduct();

	public CategoryProduct saveCategoryProduct(CategoryProduct categoryProduct);

	public CategoryProduct updateCategoryProduct(Long id,CategoryProduct categoryProduct);

	public void deleteCategoryProductByid(Long id);
}
