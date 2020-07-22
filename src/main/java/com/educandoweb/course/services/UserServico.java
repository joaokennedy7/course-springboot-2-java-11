package com.educandoweb.course.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educandoweb.course.entities.User;
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
		return obj.get();
	}
	
	public User insert(User obj) {
		return repo.save(obj);
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public User Update(Long id, User obj) {
		User entity = repo.getOne(id);
		updateData(entity, obj);
		return repo.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}


