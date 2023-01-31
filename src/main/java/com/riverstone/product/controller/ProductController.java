package com.riverstone.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.riverstone.product.dto.Category;
import com.riverstone.product.dto.Product;
import com.riverstone.product.response.ResponseStructure;
import com.riverstone.product.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;

	@PostMapping("/{categoryID}/product")
	public ResponseEntity<ResponseStructure<Product>> addProduct(@RequestBody Product newProduct,@PathVariable("categoryID") String categoryID) {
		Product insertedProduct = productService.addProduct(newProduct,categoryID);
		System.out.println(insertedProduct);
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setData(insertedProduct);
		if(insertedProduct!=null) {
			responseStructure.setMsg("product Created");
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			ResponseEntity<ResponseStructure<Product>> responseEntity= new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
			return responseEntity;
		} else {
			responseStructure.setMsg("Product not added");
			responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
			ResponseEntity<ResponseStructure<Product>> responseEntity= new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.BAD_REQUEST);
			return responseEntity;
		}
	}

	@GetMapping("/products")

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProducts() {
		List<Product> listOfProducts = productService.getProducts();
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(listOfProducts);
		if (listOfProducts.isEmpty())
			responseStructure.setMsg("No products");
		else
			responseStructure.setMsg("List of Products found");
		ResponseEntity<ResponseStructure<List<Product>>> responseEntity = new ResponseEntity<ResponseStructure<List<Product>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/products/sorted-by-price")

	public ResponseEntity<ResponseStructure<List<Product>>> getAllProductsBasedOnPrice() {
		List<Product> listOfProducts = productService.getProductsBasedOnPrice();
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(listOfProducts);
		if (listOfProducts.isEmpty())
			responseStructure.setMsg("No products");
		else
			responseStructure.setMsg("List of Products found");
		ResponseEntity<ResponseStructure<List<Product>>> responseEntity = new ResponseEntity<ResponseStructure<List<Product>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/product")
	public ResponseEntity<ResponseStructure<List<Product>>> getproductbyPrice(@RequestParam("price") double price) {
		List<Product> listOfProducts = productService.getProductByPrice(price);
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(listOfProducts);
		if (listOfProducts.isEmpty())
			responseStructure.setMsg("No products");
		else
			responseStructure.setMsg("List of Products found");
		ResponseEntity<ResponseStructure<List<Product>>> responseEntity = new ResponseEntity<ResponseStructure<List<Product>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/product/more-than")
	public ResponseEntity<ResponseStructure<List<Product>>> getproductGreaterThanPrice(@RequestParam("price") double price) {
		List<Product> listOfProducts = productService.getProductByHigherPrice(price);
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(listOfProducts);
		if (listOfProducts.isEmpty())
			responseStructure.setMsg("No products");
		else
			responseStructure.setMsg("List of Products found");
		ResponseEntity<ResponseStructure<List<Product>>> responseEntity = new ResponseEntity<ResponseStructure<List<Product>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}
	@GetMapping("/product/lesser-than")
	public ResponseEntity<ResponseStructure<List<Product>>> getproductLesserThanPrice(@RequestParam("price") double price) {
		List<Product> listOfProducts = productService.getProductFromLesserPrice(price);
		ResponseStructure<List<Product>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(listOfProducts);
		if (listOfProducts.isEmpty())
			responseStructure.setMsg("No products");
		else
			responseStructure.setMsg("List of Products found");
		ResponseEntity<ResponseStructure<List<Product>>> responseEntity = new ResponseEntity<ResponseStructure<List<Product>>>(
				responseStructure, HttpStatus.OK);
		return responseEntity;
	}

}
