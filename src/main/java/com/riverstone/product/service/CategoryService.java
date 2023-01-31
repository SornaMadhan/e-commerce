package com.riverstone.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riverstone.product.dao.CategoryDao;
import com.riverstone.product.dto.Category;

@Service
public class CategoryService {
	@Autowired
	private CategoryDao categoryDao;

	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public Category addCategory(Category newCategory) {
		return categoryDao.insertCategory(newCategory);
	}

	public List<Category> getAllCategories() {
		return categoryDao.getAllCategories();
	}

}
