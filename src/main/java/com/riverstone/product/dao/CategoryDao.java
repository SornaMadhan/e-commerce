package com.riverstone.product.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.riverstone.product.dto.Category;
import com.riverstone.product.repository.CategoryRepository;

@Repository
public class CategoryDao {
	@Autowired
	private CategoryRepository categoryRepository;

	public Category getCategory(String categoryId) {
		Optional<Category> optional = categoryRepository.findById(categoryId);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public Category insertCategory(Category newCategory) {
		return categoryRepository.save(newCategory);
	}

	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

}
