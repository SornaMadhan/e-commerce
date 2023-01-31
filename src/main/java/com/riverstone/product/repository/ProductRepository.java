package com.riverstone.product.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.riverstone.product.dto.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

	@Query(value= "From Product where price>=?1")
	List<Product> getProductByHigherPrice(double price);

	@Query(value= "From Product where price=?1")
	List<Product> getProductByPrice(double price);
	
	@Query(value= "From Product where price<=?1")
	List<Product> getProductByLesserPrice(double price);
}
