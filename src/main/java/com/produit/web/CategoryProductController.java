package com.produit.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.produit.dao.CategoryProduct;
import com.produit.service.CategoryProductService;

@CrossOrigin("*")
@RestController
public class CategoryProductController {

	@Autowired
	CategoryProductService categoryProductService;

	// find CategoryProduct by id

	@RequestMapping(value = "/category_product/{id}", method = RequestMethod.GET)
	public Optional<CategoryProduct> getCategoryProductById(@PathVariable Long id) {
		return categoryProductService.findOneCategoryProduct(id);
	}

	// find all categoryProduct

	@RequestMapping(value = "/all_category_product", method = RequestMethod.GET)
	public List<CategoryProduct> getAllCategoryProduct() {
		return categoryProductService.findAllCategoryProduct();
	}

	// save categoryProduct

	@RequestMapping(value = "save/category_product", method = RequestMethod.POST)
	public CategoryProduct saveCategoryProduct(@RequestBody CategoryProduct categoryProduct) {

		return categoryProductService.saveCategoryProduct(categoryProduct);
	}

	// update categoryProduct

	@RequestMapping(value = "/update/category_product/{id}", method = RequestMethod.PUT)
	public CategoryProduct updateCategoryProduct(@PathVariable Long id, @RequestBody CategoryProduct categoryProduct) {
		return categoryProductService.updateCategoryProduct(id, categoryProduct);

	}

	// delete categoryProduct by id

	@RequestMapping(value = "/delete/category_product/{id}", method = RequestMethod.DELETE)
	public Boolean deleteCategoryProductById(@PathVariable Long id) {
		categoryProductService.deleteCategoryProductByid(id);
		return true;
	}
}
