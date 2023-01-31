package com.riverstone.product.dto;

import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories_table")
public class Category {

	@Id
	@GenericGenerator(name = "Category", strategy = "com.riverstone.product.dao.CategoryIdGenerator")
	@GeneratedValue(generator = "Category")
	@Column(name = "Category ID")
	private String categoryId;

	@Column(name = "Category Name")
	private String categoryName;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Product> products;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(categoryId, categoryName, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(categoryId, other.categoryId) && Objects.equals(categoryName, other.categoryName)
				&& Objects.equals(products, other.products);
	}

}
