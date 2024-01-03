package com.leonardo.bookstore.dtos;

import java.io.Serializable;

import com.leonardo.bookstore.domain.Livro;

public class LivrosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String titulo;
	private String nomeAutor;

	public LivrosDTO(Livro obj) {

		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.nomeAutor = obj.getNomeAutor();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

}
