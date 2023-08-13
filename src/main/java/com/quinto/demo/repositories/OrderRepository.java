package com.quinto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quinto.demo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
