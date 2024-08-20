package com.teste.introducaospringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.introducaospringboot.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

  
}