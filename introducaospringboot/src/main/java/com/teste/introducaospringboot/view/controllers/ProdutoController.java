package com.teste.introducaospringboot.view.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.introducaospringboot.models.schema.Produto;
import com.teste.introducaospringboot.services.ProdutoService;
import com.teste.introducaospringboot.shared.ProdutoDTO;
import com.teste.introducaospringboot.view.model.ProdutoRequest;
import com.teste.introducaospringboot.view.model.ProdutoResponse;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoService produtoService;
  
  @GetMapping
  public List<ProdutoResponse> obterTodos() {
    List<ProdutoDTO> produtos = produtoService.obterTodos();

    ModelMapper mapper = new ModelMapper();

    List<ProdutoResponse> resposta = produtos.stream()
    .map(produto -> mapper.map(produto, ProdutoResponse.class))
    .collect(Collectors.toList());

    return resposta;
  }

  @GetMapping("/{id}")
  public Optional<ProdutoResponse> obterPorId(@PathVariable Integer id) {
    return produtoService.obterPorId(id);
  }

  @PostMapping
  public Produto adicionar(@RequestBody Produto produto) {
    return produtoService.adicionar(produto);
  }
  
  @PutMapping("/{id}")
  public ProdutoResponse atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest produto) {
    return produtoService.atualizar(id, produto);
  }

  @DeleteMapping("/{id}")
  public void deletar(@PathVariable Integer id) {
    produtoService.deletar(id);
  }
}
