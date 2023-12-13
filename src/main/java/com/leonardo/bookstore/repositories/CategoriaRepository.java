package com.leonardo.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.bookstore.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
