package com.quinto.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.quinto.demo.entities.User;
import com.quinto.demo.repositories.UserRepository;
import com.quinto.demo.services.exceptions.ResourceNotFoundException;
import com.quinto.demo.services.exceptions.DatabaseException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	@PutMapping(value = "/{id}")
	public User insert (User obj) {
		return repository.save(obj);
	}

	@DeleteMapping(value = "/{id}")
	public void delete (Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@PostMapping
	public User update (Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	@PostMapping
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());		
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
