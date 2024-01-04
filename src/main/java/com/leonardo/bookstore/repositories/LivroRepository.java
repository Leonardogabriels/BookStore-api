package com.leonardo.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.leonardo.bookstore.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
	@Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :idCategoria Order By titulo")
	List<Livro> findAllByCategoria(@Param(value = "idCategoria")Integer idCat);



}
