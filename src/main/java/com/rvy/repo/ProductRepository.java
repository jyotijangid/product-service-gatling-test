  
package com.rvy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rvy.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}