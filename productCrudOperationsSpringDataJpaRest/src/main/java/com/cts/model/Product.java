package com.cts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products_info")
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@Column(name = "pid")
	@GeneratedValue
	private int productId;
	@NotBlank(message="Product Name can't be null or blank")
	//@NotNull //no null
	//@NotEmpty //blank is allowed
	private String productName;
	
	@Column(name = "price")
	@Min(value=100,message="Product price should be above 100()")
	@Max(value=100000,message="Product price should be less than of 100000()") //(100,100000) in this the given value not include
	private int productPrice;
	@Size(min=5,max=12,message="category letter size or length must be between[5,12]")  // size for string min,max for string
	private String productCategory;
	@Column(name = "quantity")
	@Positive(message="quantity cant be zero or -ve")
	private int productQuantity;

	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}

}
