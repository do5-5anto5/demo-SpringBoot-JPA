package com.quinto.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quinto.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
