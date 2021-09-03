package com.rvy.service;

import java.util.List;


import com.rvy.entity.Product;
//import com.rvy.exception.ProductOperationException;

public interface ProductOperation {
	
	List<Product> getAllProducts();
	
	Product getDetailsById(Long id) throws Exception;
	
	Product addProduct(Product product) throws Exception;
	
	Product updateProduct(Product product) throws Exception;

	void deleteProduct(Long id) throws Exception;

}
