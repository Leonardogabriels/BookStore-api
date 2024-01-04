package com.leonardo.bookstore.dtos;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.leonardo.bookstore.domain.Categoria;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "O nome é obrigatório")
	@Length(min = 3, max = 100, message = "o campo nome deve ter de 3 aa 100 caracteres")
	private String nome;
	
	@NotBlank(message = "a descrição é obrigatório")
	@Length(min = 3, max = 200, message = "o campo nome deve ter de 3 aa 100 caracteres")
	private String descricao;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
