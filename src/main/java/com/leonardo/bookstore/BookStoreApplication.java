package com.leonardo.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leonardo.bookstore.domain.Categoria;
import com.leonardo.bookstore.domain.Livro;
import com.leonardo.bookstore.repositories.CategoriaRepository;
import com.leonardo.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	Categoria cat1 = new Categoria(null, "informatica", "livros de ti");
	
	Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
	
	cat1.getLivros().addAll(Arrays.asList(livro1));	
	
	this.categoriaRepository.saveAll(Arrays.asList(cat1));
	this.livroRepository.saveAll(Arrays.asList(livro1));
	}

} 
