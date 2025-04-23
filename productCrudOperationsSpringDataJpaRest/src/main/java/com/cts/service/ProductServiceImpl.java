package com.cts.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.exception.ProductNotFound;
import com.cts.model.Product;
import com.cts.repository.ProductRepository;
@Service("productService")
public class ProductServiceImpl implements ProductService {
	Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository repository;
	@Override
	public String saveProduct(Product product) {
		log.info("In ProductServiceImpl saveproduct method...");
		Product pro = repository.save(product);
		 if(pro!=null)
		 return "Product Saved Successfully";
		 else 
			 return "Product Not Saved";
	}

	@Override
	public Product updateProduct(Product product) {
		log.info("In ProductServiceImpl updateproduct method...");
		Product pro = repository.save(product);
		return pro;
	}

	@Override
	public String removeProduct(int productId) {
		log.info("In ProductServiceImpl removeproduct method...");
		repository.deleteById(productId);
		return "Product Deleted";
	}

	@Override
	public Product getProduct(int productId) throws ProductNotFound {
		log.info("In ProductServiceImpl getproduct method...");
		Optional<Product> optional = repository.findById(productId);
		if(optional.isPresent())
		return optional.get();
		else
			throw new ProductNotFound("Product id is not valid");
	}

	@Override
	public List<Product> getAllProducts() {
		log.info("In ProductServiceImpl getAllproduct method...");
		//log.error("In ProductServiceImpl getAllproduct method...");
		return repository.findAll();
	}

	@Override
	public List<Product> getAllProductsBetween(int intialPrice, int finalPrice) {
		// TODO Auto-generated method stub
		log.info("In ProductServiceImpl getAllproductsBetween method...");
		return repository.findByProductPriceBetween(intialPrice, finalPrice);
	}

	@Override
	public List<Product> getAllProductsByCategory(String category) {
		// TODO Auto-generated method stub
		log.info("In ProductServiceImpl getAllproductsByCategory method...");
		return repository.findByProductCategory(category);
	}

	@Override
	public List<Product> getAllProductsByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
