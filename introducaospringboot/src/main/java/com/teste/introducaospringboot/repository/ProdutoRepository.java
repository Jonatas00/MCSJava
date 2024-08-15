package com.teste.introducaospringboot.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.introducaospringboot.model.Produto;

@Repository
public class ProdutoRepository {
  
  private List<Produto> produtos = new ArrayList<Produto>();
  private Integer ultimoId = 0;

  /**
   * Metodo para retornar uma lista de produtos.
   * @return Lista de produtos.
   */
  public List<Produto> obterTodos() {
    return produtos;
  }

  /**
   * Metodo que retorna o produto encontrado pelo seu ID.
   * @param id do produto que sera localizado.
   * @return Retorna um produto caso tenha encontrado.
   */
  public Optional<Produto> obterPorId(Integer id) {
    return produtos.stream()
    .filter(produto -> produto.getId() == id)
    .findFirst();
  }
  
  /**
   * Metodo para adicionar produto na lista.
   * @param produto que sera adicionado.
   * @return produto que foi adicionado na lista.
   */
  public Produto adicionar(Produto produto) {
    ultimoId++;
    produto.setId(ultimoId);
    produtos.add(produto);
    return produto;
  } 

  /**
   * Metodo para deletar produto da lista.
   * @param id que sera removido.
   */
  public void deletar(Integer id) {
    produtos.removeIf(produto -> produto.getId() == id);
  }

  /**
   * Metodo para atualizar o produto na lista.
   * @param produto que sera atualizado.
   * @return produto apos a atualizar a lista.
   */
  public Produto atualizar(Produto produto) {
    Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

    if (produtoEncontrado.isEmpty()) {
      throw new InputMismatchException("Produto nao encontrado");
    }

    deletar(produto.getId());

    produtos.add(produto);

    return produto;
  }
}
