package com.teste.introducaospringboot.view.model;

import com.teste.introducaospringboot.shared.ProdutoDTO;

public class ProdutoRequest extends ProdutoDTO {
  private String nome;
  private Integer quantidade;
  private Double valor;
  private String descricao;

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public Integer getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
  public Double getValor() {
    return valor;
  }
  public void setValor(Double valor) {
    this.valor = valor;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
