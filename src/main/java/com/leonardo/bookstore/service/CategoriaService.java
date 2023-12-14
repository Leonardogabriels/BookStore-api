package com.leonardo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.bookstore.domain.Categoria;
import com.leonardo.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findByid(Integer id) {
		 Optional<Categoria> obj = categoriaRepository.findById(id);
		 return obj.orElse(null); //Optional pois pode ou não encontrar o id
	}

}
