package com.javachinna.repo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javachinna.model.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Transactional
	@Modifying
	@Query("update Product set name=:name where id=:id")
	void updateProduct(String name, Long id);
}
