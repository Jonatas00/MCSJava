package com.teste.introducaospringboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

  //#region Atributos
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String nome;
  private Integer quantidade;
  private Double valor;
  private String descricao;
  //#endregion
  
  //#region Getters e Setters
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
  //#endregion
    
}
