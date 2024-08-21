package com.teste.introducaospringboot.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.introducaospringboot.models.exception.ResourceNotFoundException;
import com.teste.introducaospringboot.models.schema.Produto;
import com.teste.introducaospringboot.repository.ProdutoRepository;
import com.teste.introducaospringboot.shared.ProdutoDTO;

@Service
public class ProdutoService {
  
  /* @Autowired devolve instância pronta do repositorio */
  @Autowired
  private ProdutoRepository produtoRepository;
  
  /*
   * Metodo para retornar uma lista de produtos.
   * @return Lista de produtos.
   */
  public List<ProdutoDTO> obterTodos() {

    List<Produto> produtos = produtoRepository.findAll();

    return produtos.stream()
    .map(p -> new ModelMapper().map(p, ProdutoDTO.class))
    .collect(Collectors.toList());
  }

  /**
   * Metodo que retorna o produto encontrado pelo seu ID.
   * @param id do produto que sera localizado.
   * @return Retorna um produto caso tenha encontrado.
   */
  public Optional<ProdutoDTO> obterPorId(Integer id) {
    Optional<Produto> produto = produtoRepository.findById(id);
    if (produto.isEmpty()) {
      throw new ResourceNotFoundException("Produto com id " + id + " não foi encontrado");
    }

    ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);

    return Optional.of(dto);
  }

  /**
   * Metodo para adicionar produto na lista.
   * @param produto que sera adicionado.
   * @return produto que foi adicionado na lista.
   */
  public ProdutoDTO adicionar(ProdutoDTO produtodto) {
    produtodto.setId(null);

    ModelMapper mapper = new ModelMapper();

    Produto produto = mapper.map(produtodto, Produto.class);
    
    produto = produtoRepository.save(produto);

    produtodto.setId(produto.getId());

    return produtodto;
  }

  /**
   * Metodo para deletar produto da lista.
   * @param id que sera removido.
   */
  public void deletar(Integer id) {
    Optional<Produto> produto = produtoRepository.findById(id);
    if (produto.isEmpty()) {
      throw new ResourceNotFoundException("Não foi possível deletar o produto com o id: " + id + " produto não existe");
    }
    produtoRepository.deleteById(id);
  }

  /**
   * Metodo para atualizar o produto na lista.
   * @param id do produto que será atualizado
   * @param produto que sera atualizado.
   * @return produto apos a atualizar a lista.
   */
  public ProdutoDTO atualizar(Integer id, ProdutoDTO produtodto) {
    produtodto.setId(id);

    ModelMapper mapper = new ModelMapper();

    Produto produto = mapper.map(produtodto, Produto.class);

    produtoRepository.save(produto);

    return produtodto;
  }
}
