package com.livrei.les.ecomercy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.livrei.les.ecomercy.application.Result;
import com.livrei.les.ecomercy.domain.Client;
import com.livrei.les.ecomercy.repositories.UserRepository;
import com.livrei.les.ecomercy.services.exception.DatabaseException;
import com.livrei.les.ecomercy.services.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService implements IService<Client>{
	
	@Autowired
	private UserRepository repository;
	

	
	@Override
	public Result insert(Client client) {
        Result result = new Result();
        try {
            Client saved = repository.save(client);
            result.setEntities(List.of(saved));
            result.setSuccess(true);
            result.setStatusCode(201);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Erro ao salvar cliente: " + e.getMessage());
            result.setStatusCode(500);
        }
        return result;
	}
	
	public Result delete(Long id) {
		repository.findById(id).orElseThrow(
		        () -> new ResourceNotFoundException(id)); 
		    try { 
		        repository.deleteById(id); 
		    } catch (DataIntegrityViolationException e) { 
		        throw new DatabaseException(e.getMessage()); 
		    }  
		    return new Result();
	}

	@Override
	public Result update(Long id, Client obj) {
		repository.findById(id).orElseThrow(
		        () -> new ResourceNotFoundException(id)); 
		try {
		Optional<Client> entity = repository.findById(id);

		//return repository.save(entity.get());

	    return new Result();
		
		}catch(EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
		}
	}

	@Override
	public Result findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}





}
