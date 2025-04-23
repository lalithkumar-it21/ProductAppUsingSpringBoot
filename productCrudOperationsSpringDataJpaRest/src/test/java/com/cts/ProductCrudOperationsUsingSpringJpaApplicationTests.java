package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.service.ProductService;

@SpringBootTest
class ProductCrudOperationsUsingSpringJpaApplicationTests {
	@Autowired
	ProductService service;
	@Test
	void saveProducttest() {
		Product product = new Product("samsung",2300,"electronics",20);
		String response = service.saveProduct(product);
		assertEquals("Product Saved Successfully", response);
	}

}


//package com.cts;

//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cts.model.Product;
//import com.cts.service.ProductServiceImpl;
//
//@SpringBootTest
//class ProductCrudOperationsUsingSpringJpaApplicationTests {
//	@Mock
//	ProductRepositoryImpl repository;
//	@InjectMocks
//	ProductServiceImpl service;
//	@Test
//	void saveProducttest() {
//		Product product = new Product("samsung",2300,"electronics",20);
//		Mockito.when(repository.save(product)).thenReturn("Product Saved Successfully");
//		String response = service.saveProduct(product);
//	 assertEquals("Product Saved Successfully", response);
//	}
//
//}
