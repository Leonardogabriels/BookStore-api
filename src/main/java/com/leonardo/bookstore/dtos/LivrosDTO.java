package com.leonardo.bookstore.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.leonardo.bookstore.domain.Livro;

import jakarta.validation.constraints.NotBlank;

public class LivrosDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotBlank(message = "O titulo é obrigatório")
	@Length(min = 3, max = 50, message = "o campo titulo deve ter de 3 aa 50 caracteres")
	private String titulo;
	
	
	public LivrosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivrosDTO(Livro obj) {

		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();

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

}
