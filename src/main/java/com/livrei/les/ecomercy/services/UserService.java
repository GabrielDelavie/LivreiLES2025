package com.livrei.les.ecomercy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.livrei.les.ecomercy.domain.User;
import com.livrei.les.ecomercy.repositories.UserRepository;
import com.livrei.les.ecomercy.services.exception.DatabaseException;
import com.livrei.les.ecomercy.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(()-> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.findById(id).orElseThrow(
		        () -> new ResourceNotFoundException(id)); 
		    try { 
		        repository.deleteById(id); 
		    } catch (DataIntegrityViolationException e) { 
		        throw new DatabaseException(e.getMessage()); 
		    }  
	}
	
	public User update(Long id, User obj) {
		repository.findById(id).orElseThrow(
		        () -> new ResourceNotFoundException(id)); 
		try {
		Optional<User> entity = repository.findById(id);
		updateData(entity.get(), obj);
		return repository.save(entity.get());
		}catch(EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
