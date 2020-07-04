package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public List<Category> findAll(){
		return repo.findAll();
	}

	public Category findById(Long id) {
		Optional<Category> obj = repo.findById(id);
		return obj.get();
	}
	
}
