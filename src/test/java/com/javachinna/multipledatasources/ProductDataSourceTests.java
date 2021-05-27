package com.javachinna.multipledatasources;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.javachinna.model.product.Product;
import com.javachinna.model.product.ProductInfo;
import com.javachinna.repo.product.ProductInfoRepository;
import com.javachinna.repo.product.ProductRepository;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class ProductDataSourceTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@BeforeAll
	public void init() {
		Product product = new Product("phone", "secret");
		product = productRepository.save(product);
	}

	@Test
	public void getProductTest() {
		List<Product> list = productRepository.findAll();
		assertThat(list).isNotEmpty();
	}

	@Test
	public void getProductInfoTest() {
		List<ProductInfo> list = productInfoRepository.getProductInfo();
		assertThat(list).isNotEmpty();
		assertThat(list.get(0).getName()).isEqualTo("phone");
	}

	@Test
	public void updateProductTest() {
		productRepository.updateProduct("smartphone", 1L);
		Optional<Product> product = productRepository.findById(1L);
		assertThat(product.get().getName()).isEqualTo("smartphone");
	}

	@Test
	public void updateProductInfoTest() {
		productInfoRepository.updateProductInfo("cellphone", 1L);
		Optional<Product> product = productRepository.findById(1L);
		assertThat(product.get().getName()).isEqualTo("cellphone");
	}

}
