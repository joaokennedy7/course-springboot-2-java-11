package com.educandoweb.course.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
public class ProductServico {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> findAll(){
		return repo.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> obj = repo.findById(id);
	return obj.get();
	}
	
}
