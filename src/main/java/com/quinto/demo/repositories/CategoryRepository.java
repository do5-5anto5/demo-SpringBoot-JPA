package com.quinto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quinto.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
