package com.leonardo.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leonardo.bookstore.domain.Categoria;
import com.leonardo.bookstore.dtos.CategoriaDTO;
import com.leonardo.bookstore.exception.DataIntegrityViolationException;
import com.leonardo.bookstore.exception.ObjectNotFoundException;
import com.leonardo.bookstore.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria findByid(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id " + id + "tipo " + Categoria.class.getName())); // Optional pois pode ou não
		// Caso não ache a categoria devolve minha exessão personalizada // encontrar o
		// id
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria create(Categoria obj) {
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO obj) {
		Categoria up = findByid(id);
		up.setNome(obj.getNome());
		up.setDescricao(obj.getDescricao());
		return categoriaRepository.save(up);

	}

	public void delete(Integer id) {
	    Categoria categoria = findByid(id);

	    if (categoria != null) {
	        try {
	            categoriaRepository.deleteById(id);
	        } catch (DataIntegrityViolationException e) {
	            throw new DataIntegrityViolationException("Categoria não pode ser deletada, pois possui livros associados");
	        }
	    } else {
	        throw new IllegalArgumentException("Categoria não encontrada com o ID: " + id);
	    }
	}

}
