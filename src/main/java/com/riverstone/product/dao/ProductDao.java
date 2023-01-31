package com.riverstone.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.riverstone.product.dto.Product;
import com.riverstone.product.repository.ProductRepository;
@Repository
public class ProductDao {
	@Autowired
	private ProductRepository productRepository;
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	public List<Product> displayAllBasedOnPrice() {
		return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"));
	}
	public List<Product> getProductByPrice(double price) {
		return productRepository.getProductByPrice(price);
	}
	public List<Product> getProductByHigherPrice(double price) {
		return productRepository.getProductByHigherPrice(price);
	}
	public List<Product> getProductFromLesserPrice(double price) {
		return productRepository.getProductByLesserPrice(price);
	}
	public Product addProduct(Product newProduct) {
		return productRepository.save(newProduct);
	}
	
	

}
