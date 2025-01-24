package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	ProductRepository repository;

	/*
	 * @Autowired public ProductServiceImpl(ProductRepository repository) { super();
	 * this.repository = repository; }
	 */

	@Override
	public String addProduct(Product product) {
		Product product1 = repository.save(product); // save method reutrn is our entity
		if (product1 != null)
			return "Product saved successfully";
		else
			return "Failed to save product";

	}

	@Override
	public Product updateProduct(Product product) {
		return repository.save(product);
	}

	@Override
	public String deleteProduct(int productId) {
		repository.deleteById(productId);
		return "Product deleted successfully";
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFound {
		Optional<Product> optional = repository.findById(productId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new ProductNotFound("No product Found With Given Id!!!");
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int initialPrice, int finalPrice) {

		return repository.findByproductPriceBetween(initialPrice, finalPrice);
	}

	@Override
	public List<Product> getAllProductByCategory(String productCategory) {
		return repository.findByproductCategory(productCategory);
	}

	@Override
	public List<Product> getAllCategoryByPrice(String productCategory, int productPrice) {
		return repository.findByProductCategoryAndProductPriceLessThan(productCategory, productPrice);
	}

}
