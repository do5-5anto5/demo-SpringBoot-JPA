package com.quinto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quinto.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
