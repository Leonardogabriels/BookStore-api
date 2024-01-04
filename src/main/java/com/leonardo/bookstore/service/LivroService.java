package com.leonardo.bookstore.service;

import java.util.List;
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
	
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id){
		Optional<Livro> obj = Repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado id " + id + "tipo " + Categoria.class.getName()));
		
	}

	public List<Livro> findAll(Integer idCategoria) {
	    Categoria categoria = categoriaService.findByid(idCategoria);

	    if (categoria == null) {
	        // Lógica para tratar categoria não encontrada, como lançar uma exceção
	        throw new RuntimeException("Categoria não encontrada para o ID: " + idCategoria);
	    }

	    return Repository.findAllByCategoria(idCategoria);
	}



	
	public Livro update(Integer id, Livro obj) {
		Livro up = findById(id);
		updateData(up,obj);		
		return Repository.save(up);
		
	}
	
	private void updateData(Livro newObj, Livro obj) {
		newObj.setNomeAutor(obj.getNomeAutor());;
		newObj.setTitulo(obj.getTitulo());
		newObj.setTexto(obj.getTexto());
		
	}

	public void delete(Integer id) {
	    Livro LivroDel = findById(id);

		if (LivroDel != null) {

			Repository.deleteById(id);

		} else {
			throw new IllegalArgumentException("Livro não encontrada com o ID: " + id);
		}
	}
	
	public Livro create(Integer idCat,Livro obj) {
		Categoria cat = categoriaService.findByid(idCat);
		obj.setCategoria(cat);
		return Repository.save(obj);
	}
}
