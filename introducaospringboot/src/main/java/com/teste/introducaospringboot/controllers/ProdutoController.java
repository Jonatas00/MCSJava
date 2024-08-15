package com.teste.introducaospringboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.introducaospringboot.models.Produto;
import com.teste.introducaospringboot.services.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;
  
  @PostMapping
  public Produto adicionar(@RequestBody Produto produto) {
    return produtoService.adicionar(produto);
  }

  @GetMapping
  public List<Produto> obterTodos() {
    return produtoService.obterTodos();
  }

  @GetMapping("/{id}")
  public Optional<Produto> obterPorId(@PathVariable Integer id) {
    return produtoService.obterPorId(id);
  }
}
