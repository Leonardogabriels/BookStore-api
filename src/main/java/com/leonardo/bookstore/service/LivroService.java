package com.leonardo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.bookstore.domain.Categoria;
import com.leonardo.bookstore.domain.Livro;
import com.leonardo.bookstore.dtos.LivrosDTO;
import com.leonardo.bookstore.exception.DataIntegrityViolationException;
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
	
	public List<Livro> findAll() {
		return Repository.findAll();
	}

	
	public Livro update(Integer id, LivrosDTO obj) {
		Livro up = findById(id);
		up.setNomeAutor(obj.getNomeAutor());;
		up.setTitulo(obj.getTitulo());
		return Repository.save(up);
		
	}
	
	public void delete(Integer id) {
	    Livro LivroDel = findById(id);

		if (LivroDel != null) {

			Repository.deleteById(id);

		} else {
			throw new IllegalArgumentException("Livro não encontrada com o ID: " + id);
		}
	}
}
