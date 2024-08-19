package com.teste.introducaospringboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.introducaospringboot.models.Cliente;
import com.teste.introducaospringboot.repository.ClienteRepository;

@Service
public class ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

   /**
   * Metodo para retornar uma lista de clientes.
   * @return lista de clientes.
   */
  public List<Cliente> buscarTodos() {
    return clienteRepository.buscarTodos();
  }

  /**
   * Metodo para retornar um cliente pelo id.
   * @param id do cliente que será retornado.
   * @return cliente com o id selecionado.
   */
  public Optional<Cliente> buscarPorId(Integer id) {
    return clienteRepository.buscarPorId(id);
  }

  /**
   * Metodo para adicionar um cliente na lista.
   * @param cliente que será adicionado
   * @return cliente que foi adicionado
   */
  public Cliente adicionar(Cliente cliente) {
    return clienteRepository.adicionar(cliente);
  }

  /**
   * Metodo para atualizar o cliente na lista.
   * @param id do cliente que será atualizado.
   * @param cliente que sera atualizado.
   * @return cliente apos a atualizar a lista.
   */
  public Cliente atualizar(Integer id, Cliente cliente) {
    cliente.setId(id);
    return clienteRepository.atualizar(cliente);
  }

  /**
   * Metodo para deletar cliente da listas.
   * @param id do cliente que será deletado.
   */
  public void deletar(Integer id) {
    clienteRepository.deletar(id);
  }
}
