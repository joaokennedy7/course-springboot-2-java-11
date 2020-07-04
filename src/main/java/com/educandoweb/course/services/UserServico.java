package com.educandoweb.course.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.exception.UserNotFindException;
import com.educandoweb.course.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserServico {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repo.findById(id);
		User user1 = null;
		try {
			user1 = obj.get();	
		}catch (NoSuchElementException e) {
			throw new UserNotFindException("usuario com id " + id + " nao existe");
		} 
			
		
		return user1;
	}
	
	public void createUser(User usuario) {
		log.info("Tentando criar um usuario: {}", usuario);
		repo.save(usuario);
	}
}
