package com.quinto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quinto.demo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
