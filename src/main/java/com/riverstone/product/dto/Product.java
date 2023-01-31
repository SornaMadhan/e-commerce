package com.riverstone.product.dto;

import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Join;

@Entity
@Table(name = "products_table")
public class Product {

	@Id
	@GenericGenerator(name = "productId", strategy = "com.riverstone.product.dao.ProductIdGenerator")
	@GeneratedValue(generator = "productId")
	@Column(name = "Product ID")
	private String productId;

	@Column(name = "Product Name")
	private String productName;

	@Column(name = "Price")
	private double price;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "categoryId")
	private Category category;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	@JsonIgnore
	public void setCategory(Category category) {
		this.category = category;
	}

//	@Override
//	public String toString() {
//		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
//	}
	

	@Override
	public int hashCode() {
		return Objects.hash(category, price, productId, productName);
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", category="
				+ category + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName);
	}

}
