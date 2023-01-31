package com.riverstone.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riverstone.product.dto.Category;
import com.riverstone.product.dto.Product;
import com.riverstone.product.response.ResponseStructure;
import com.riverstone.product.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public ResponseEntity<ResponseStructure<Category>> addCategory(@RequestBody Category newCategory) {
		Category insertedCategory=categoryService.addCategory(newCategory);
		ResponseStructure<Category> responseStructure = new ResponseStructure<>();
		responseStructure.setData(insertedCategory);
		if(insertedCategory!=null) {
			responseStructure.setMsg("Category Created");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			ResponseEntity<ResponseStructure<Category>> responseEntity= new ResponseEntity<ResponseStructure<Category>>(responseStructure, HttpStatus.CREATED);
			return responseEntity;
		} else {
			responseStructure.setMsg("Category not added");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			ResponseEntity<ResponseStructure<Category>> responseEntity= new ResponseEntity<ResponseStructure<Category>>(responseStructure, HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}

	@GetMapping("/category")
	public ResponseEntity<ResponseStructure<Category>> getCategory(@RequestParam("categoryId") String categoryId) {
		Category category = categoryService.getCategory(categoryId);
		ResponseStructure<Category> responseStructure = new ResponseStructure<>();
		responseStructure.setData(category);
		responseStructure.setStatusCode(HttpStatus.OK.value());
		if (category != null)
			responseStructure.setMsg("Data Found");
		else
			responseStructure.setMsg("Data NotFound");
		ResponseEntity<ResponseStructure<Category>> responseEntity = new ResponseEntity<ResponseStructure<Category>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;

	}
	
	@GetMapping("/categories")
	public ResponseEntity<ResponseStructure<List<Category>>> getAllCategories() {
		List<Category> list=categoryService.getAllCategories();
		ResponseStructure<List<Category>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(list);
		if (list.isEmpty())
			responseStructure.setMsg("list is empty");
		else
			responseStructure.setMsg("List of Categories found");
		ResponseEntity<ResponseStructure<List<Category>>> responseEntity = new ResponseEntity<ResponseStructure<List<Category>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}
}
