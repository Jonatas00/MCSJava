package com.teste.introducaospringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.introducaospringboot.models.Produto;
import com.teste.introducaospringboot.repository.ProdutoRepository;

@Service
public class ProdutoService {
  
  /* @Autowired devolve instância pronta do repositorio */
  @Autowired
  private ProdutoRepository produtoRepository;

  /**
   * Metodo para retornar uma lista de produtos.
   * @return Lista de produtos.
   */
  public List<Produto> obterTodos() {
    return produtoRepository.obterTodos();
  }

  /**
   * Metodo que retorna o produto encontrado pelo seu ID.
   * @param id do produto que sera localizado.
   * @return Retorna um produto caso tenha encontrado.
   */
  public Optional<Produto> obterPorId(Integer id) {
    return produtoRepository.obterPorId(id);
  }

  /**
   * Metodo para adicionar produto na lista.
   * @param produto que sera adicionado.
   * @return produto que foi adicionado na lista.
   */
  public Produto adicionar(Produto produto) {
    return produtoRepository.adicionar(produto);
  }

  /**
   * Metodo para deletar produto da lista.
   * @param id que sera removido.
   */
  public void deletar(Integer id) {
    produtoRepository.deletar(id);
  }

  /**
   * Metodo para atualizar o produto na lista.
   * @param id do produto que será atualizado
   * @param produto que sera atualizado.
   * @return produto apos a atualizar a lista.
   */
  public Produto atualizar(Integer id, Produto produto) {
    produto.setId(id);
    return produtoRepository.atualizar(produto);
  }
}
