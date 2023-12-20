package com.leonardo.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.leonardo.bookstore.domain.Categoria;
import com.leonardo.bookstore.domain.Livro;
import com.leonardo.bookstore.repositories.CategoriaRepository;
import com.leonardo.bookstore.repositories.LivroRepository;

@Service
public class DBservice implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		Categoria cat1 = new Categoria(null, "informatica", "livros de ti");
		Categoria cat2 = new Categoria(null, "finanças", "livros que te ajudam a tratar melhor o dinheiro");
		Categoria cat3 = new Categoria(null, "auto ajuda", "livros para melhorar seu maindset");
		
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro livro2 = new Livro(null, "mais espero que o diabo", "Napoleon Hill", "Lorem Ipsum", cat2);
		Livro livro3 = new Livro(null, "do mil ao milão", "thiago nigro", "Lorem Ipsum", cat3);
		Livro livro4 = new Livro(null, "quem pensa enriquece", "Napoleon Hill", "Lorem Ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(livro1,livro2,livro3,livro4));	
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(livro1,livro2,livro3,livro4));
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "informatica", "livros de ti");
		Categoria cat2 = new Categoria(null, "finanças", "livros que te ajudam a tratar melhor o dinheiro");
		Categoria cat3 = new Categoria(null, "auto ajuda", "livros para melhorar seu maindset");
		
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro livro2 = new Livro(null, "mais espero que o diabo", "Napoleon Hill", "Lorem Ipsum", cat2);
		Livro livro3 = new Livro(null, "do mil ao milão", "thiago nigro", "Lorem Ipsum", cat3);
		Livro livro4 = new Livro(null, "quem pensa enriquece", "Napoleon Hill", "Lorem Ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(livro1,livro2,livro3,livro4));	
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		this.livroRepository.saveAll(Arrays.asList(livro1,livro2,livro3,livro4));
	}

}
