package com.cts.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;
 
@RestController
@RequestMapping("/products") // http://localhost:1113/products
public class ProductController {
	@Autowired
	ProductService service;
 
	@GetMapping("/getMsg") //@RequestMapping(value="/getMsg",method=RequestMathod.Get)
	//http://localhost:1113/products/getMsg
	public String sayHello() {
		return "I am trying to listen but am getting sleep";
	}
 
	@PostMapping("/saveproduct") // http://localhost:1113/products/saveproduct
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);// we use post it is new data
	}
	@PutMapping("/updateproduct") // http://localhost:1113/products/updateproduct
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);//put for retrieve existing data
	}
	
	@GetMapping("/getproduct/{pid}") // http://localhost:1113/products/getproduct/1
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	

	
	@GetMapping("/removeproduct/{pid}") // http://localhost:1113/products/removeproduct/2
		public String removeProduct(@PathVariable("pid") int productId) {
			return service.removeProduct(productId);
		}
		@GetMapping("/getAllProducts") // http://localhost:1113/products/getAllProducts
		public List<Product> getAllProducts() {
			return service. getAllProducts();
		}
		@GetMapping("/getallproductsbetween/{price1}/{price2}") // http://localhost:1113/products/getallproductsbetween/2000/10000
		public List<Product> fetchProductsBetween(@PathVariable("price1") int intialPrice,
				@PathVariable("price2") int finalPrice) {
			return service.getAllProductsBetween(intialPrice, finalPrice);
		}
	 
		@GetMapping("/getallproductsbycategory/{category}") // http://localhost:1113/products/getallproductsbycategory/electronics
		public List<Product> fetchProductByCategory(@PathVariable("category") String category) {
			return service.getAllProductsByCategory(category);
		}
		
		
	
}
 
 