package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.ProductNotFound;
import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products") // http://localhost:8080/products
public class ProductController {

	@Autowired
	ProductService service;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@PostMapping("/save") // http://localhost:8080/products/save
	public String saveProduct(@RequestBody Product product) {
		logger.info("New products added");
		return service.addProduct(product);
	}

	@PutMapping("/update") // http://localhost:8080/products/update
	public Product updateProduct(@RequestBody Product product) {
		logger.info("Product Updated successfully ");
		return service.updateProduct(product);
	}

	@DeleteMapping("/delete/{id}") // http://localhost:8080/products/delete/123
	public String deleteProduct(@PathVariable("id") int productId) {
		logger.info("Product deleted successfully !!!");
		return service.deleteProduct(productId);
	}

	@GetMapping("/getbyid/{id}") // http://localhost:8080/products/getbyid/123
	public Product getProduct(@PathVariable("id") int productId) throws ProductNotFound {
		logger.info("Got product by ID");
		return service.getProductById(productId);
	}

	@GetMapping("/getall") // http://localhost:8080/products/getall
	public List<Product> getAllProducts() {
		logger.info("showing all the prodeucts.");
		return service.getAllProducts();
	}

	@GetMapping("/getallbetween/{price1}/{price2}") // http://localhost:8080/products/getallbetween/1000/2000
	public List<Product> getAllBetween(@PathVariable("price1") int initialPrice,
			@PathVariable("price2") int finalPrice) {
		logger.info("showing all the products between the mentioned price range.");
		return service.getAllProductsBetween(initialPrice, finalPrice);
	}

	@GetMapping("/getallbycat/{pCategory}") // http://localhost:8080/products/getallbycat/phone
	public List<Product> getAllByCategory(@PathVariable("pCategory") String productCategory) {
		logger.info("showing all the products by category.");
		return service.getAllProductByCategory(productCategory);
	}

	@GetMapping("/getcatgorybyprice/{pCategory}/{pPrice}") // http://localhost:8080/products/getcatgorybyprice/Phone/20000
	public List<Product> getAllByPrice(@PathVariable("pCategory") String productCategory,
			@PathVariable("pPrice") int productPrice) {
		logger.info("showing all the products category witin the mentioned price range.");
		return service.getAllCategoryByPrice(productCategory, productPrice);
	}
}
