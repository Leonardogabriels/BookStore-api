package com.leonardo.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.bookstore.domain.Categoria;
import com.leonardo.bookstore.domain.Livro;
import com.leonardo.bookstore.exception.ObjectNotFoundException;
import com.leonardo.bookstore.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository Repository;
	
	public Livro findById(Integer id){
		Optional<Livro> obj = Repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id " + id + "tipo " + Categoria.class.getName()));
		
	}

}
