package com.riverstone.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riverstone.product.dto.Category;

public interface CategoryRepository extends JpaRepository<Category, String>{

}
