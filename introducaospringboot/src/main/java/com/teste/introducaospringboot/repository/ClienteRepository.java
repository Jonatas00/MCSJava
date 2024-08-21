package com.teste.introducaospringboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.introducaospringboot.models.schema.Cliente;

import java.util.ArrayList;

@Repository
public class ClienteRepository {
  private List<Cliente> clientes = new ArrayList<Cliente>();
  private Integer ultimoId = 0;

  /**
   * Metodo para retornar uma lista de clientes.
   * @return lista de clientes.
   */
  public List<Cliente> buscarTodos() {
    return clientes;
  }

  /**
   * Metodo para retornar um cliente pelo id.
   * @param id do cliente que será retornado.
   * @return cliente com o id selecionado.
   */
  public Optional<Cliente> buscarPorId(Integer id) {
    return clientes.stream()
    .filter(cliente -> cliente.getId() == id)
    .findFirst();
  }

  /**
   * Metodo para adicionar um cliente na lista.
   * @param cliente que será adicionado
   * @return cliente que foi adicionado
   */
  public Cliente adicionar(Cliente cliente) { 
    cliente.setId(ultimoId);
    clientes.add(cliente);
    ultimoId++;
    return cliente;
  }

  /**
   * Metodo para atualizar o cliente na lista.
   * @param cliente que sera atualizado.
   * @return cliente apos a atualizar a lista.
   */
  public Cliente atualizar(Cliente cliente) {
    Optional<Cliente> clienteEncontrado = buscarPorId(cliente.getId()); 

    if (clienteEncontrado.isEmpty()) {
      throw new Error("Cliente não encontrado");
    }

    deletar(cliente.getId());
    clientes.add(cliente);

    return cliente;
  }

  /**
   * Metodo para deletar cliente da listas.
   * @param id do cliente que será deletado.
   */
  public void deletar(Integer id) {
    clientes.removeIf(cliente -> cliente.getId() == id);
  }
}
