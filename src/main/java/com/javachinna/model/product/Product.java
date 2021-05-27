package com.javachinna.model.product;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@SqlResultSetMapping(name = "ProductInfoMapping", classes = @ConstructorResult(targetClass = ProductInfo.class, columns = {@ColumnResult(name = "id", type = String.class),
		@ColumnResult(name = "name", type = String.class), @ColumnResult(name = "price", type = String.class)}))
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String price;
	/**
	 * @param name
	 * @param price
	 */
	public Product(String name, String price) {
		this.name = name;
		this.price = price;
	}

}
