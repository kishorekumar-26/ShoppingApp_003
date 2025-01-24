package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	@Query("select p from Product p where p.productPrice between ?1 and ?2 ")
//	public List<Product> getAllProductsBetween(int initialPrice,int finalPrice);
//	@Query("select p from Product p where productCategory = ?1 ")
//	public List<Product> getAllProductByCategory(String productCategory);

	public List<Product> findByproductPriceBetween(int initialPrice, int finalPrice);

	public List<Product> findByproductCategory(String productCategory);

	public List<Product> findByProductCategoryAndProductPriceLessThan(String productCategory, int productPrice);
}
