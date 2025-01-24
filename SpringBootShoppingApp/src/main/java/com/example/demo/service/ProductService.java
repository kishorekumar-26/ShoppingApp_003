package com.example.demo.service;

import java.util.List;

import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.model.Product;

public interface ProductService {

	public String addProduct(Product product);

	public Product updateProduct(Product product);

	public String deleteProduct(int productId);

	public Product getProductById(int productId) throws ProductNotFound;

	public List<Product> getAllProducts();

	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice);

	public List<Product> getAllProductByCategory(String productCategory);

	public List<Product> getAllCategoryByPrice(String productCategory,int productPrice);

}
