package com.rvy.controller;


import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvy.entity.Product;
//import com.rvy.exception.ProductOperationException;
import com.rvy.service.ProductOperation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
//@Api
@RequestMapping("/pms/v1")
public class ProductManagerController {
	
	@Autowired
	private ProductOperation productOperation;

//	@ApiOperation(value = "Product by id",
//			consumes = "product master Id",
//			produces = "Product object",
//			response = Product.class,
//			tags = "Find product by id",
//			notes = "http://localhost:8081/rvy/api/pms/v1/product/{id}")
	@GetMapping(value = "/product/{id}")
	public ResponseEntity<Object> findProductById(@PathVariable("id") Long id) throws Exception{
		Product product = this.productOperation.getDetailsById(id);
		return ResponseEntity.ok(product);
		
	}

//	@ApiOperation(value = "List of all products",
//			consumes = "",
//			produces = "All the products",
//			response = Product.class,
//			tags = "Get All Products",
//			notes = "http://localhost:8081/rvy/api/pms/v1/products")
	@GetMapping("/products")
	public ResponseEntity<Object> getAllProducts() throws Exception{
		List<Product> products = this.productOperation.getAllProducts();
		return ResponseEntity.ok(products);
	}


	// http://localhost:8081/rvy/api/pms/v1/product
//	@ApiOperation(value = "Add product to product master",
//			produces = "Product object",
//			response = Product.class,
//			tags = "Add Product",
//			notes = "http://localhost:8081/rvy/api/pms/v1/product")
	@PostMapping("/product")
	public ResponseEntity<Object> addProduct(@RequestBody Product product) throws Exception{
		Product productadd = this.productOperation.addProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productadd);
	}

	// http://localhost:8081/rvy/api/pms/v1/product
//	@ApiOperation(value = "Update order",
//			consumes = "Product object",
//			produces = "Product object",
//			response =Product.class,
//			tags = "Update Product Master",
//			notes = "http://localhost:8081/rvy/api/pms/v1/product")
	@PutMapping("/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws Exception{
		Product updated = this.productOperation.updateProduct(product);
//		return ResponseEntity.ok(updated);
		return new ResponseEntity<Product>(updated, HttpStatus.OK);
	
	}

	// http://localhost:8081/rvy/api/pms/v1/product/1
//	@ApiOperation(value = "Delete",
//			consumes = "product Master Id",
//			produces = "Product Object",
//			response = Product.class,
//			tags="Delete A Product",
//			notes ="http://localhost:8081/rvy/api/pms/v1/product/{id}")
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") Long id) throws Exception{
//		Long _id = Long.valueOf(id);
		this.productOperation.deleteProduct(id);
		return ResponseEntity.ok().build();
	}

}

