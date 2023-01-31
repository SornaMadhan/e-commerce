package com.riverstone.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverstone.product.dao.ProductDao;
import com.riverstone.product.dto.Category;
import com.riverstone.product.dto.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CategoryService categoryService;

	public List<Product> getProducts() {
		return productDao.getAllProducts();
	}

	public List<Product> getProductsBasedOnPrice() {
		return productDao.displayAllBasedOnPrice();
	}

	public List<Product> getProductByPrice(double price) {
		return productDao.getProductByPrice(price);
	}
	public List<Product> getProductByHigherPrice(double price) {
		return productDao.getProductByHigherPrice(price);
	}
	public List<Product> getProductFromLesserPrice(double price) {
		return productDao.getProductFromLesserPrice(price);
	}

	public Product addProduct(Product newProduct, String categoryID) {
		Category searchedCategory = categoryService.getCategory(categoryID);
		if (searchedCategory != null)
			newProduct.setCategory(searchedCategory);
		return productDao.addProduct(newProduct);
	}

}
