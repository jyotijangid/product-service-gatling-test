package com.rvy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

//import com.rvy.dao.ProductMasterRepository;
import com.rvy.entity.Product;
//import com.rvy.exception.ProductOperationException;
import com.rvy.repo.ProductRepository;

@Service
@CacheConfig(cacheNames = "productCache")
public class ProductOperationsImpl implements ProductOperation{
	

	@Autowired
	private ProductRepository productMasterRepo;
	
	@Override
	@Cacheable(cacheNames = "products")
	public List<Product> getAllProducts() {
		waitSomeTime();
		return this.productMasterRepo.findAll();
	}

	@Cacheable(cacheNames = "product", key = "#id", unless = "#result == null")
	@Override
	public Product getDetailsById(Long id) {
		return this.productMasterRepo.findById(id).orElse(null);	
	}
	
	
	@Override
	@CacheEvict(cacheNames = "products", allEntries = true)
	public Product updateProduct(Product product){
		Optional<Product> optProduct = this.productMasterRepo.findById(product.getProductId());
		if (!optProduct.isPresent())
			return null;
		Product repProduct = optProduct.get();
		repProduct.setBrand(product.getBrand());;
		repProduct.setCategory(product.getCategory());;
		repProduct.setImage(product.getImage());
		repProduct.setProductDesc(product.getProductDesc());;
		repProduct.setProductName(product.getProductName());;
		repProduct.setType(product.getType());;
		return this.productMasterRepo.save(repProduct); 
	}

	@Override
	@CacheEvict(cacheNames = "products", allEntries = true)
	public Product addProduct(Product product){
		return this.productMasterRepo.save(product);
	}

	
	@Caching(evict = { @CacheEvict(cacheNames = "product", key = "#id"),
			@CacheEvict(cacheNames = "products", allEntries = true) })
	@Override
	public void deleteProduct(Long id) {
		this.productMasterRepo.findById(id).orElse(null);
	}
	
	
	private void waitSomeTime() {
		System.out.println("Long Wait Begin");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Long Wait End");
	}

}