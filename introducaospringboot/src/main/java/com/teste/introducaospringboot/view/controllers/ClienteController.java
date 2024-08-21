package com.teste.introducaospringboot.view.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.introducaospringboot.models.schema.Cliente;
import com.teste.introducaospringboot.services.ClienteService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @PostMapping
  public Cliente adicionar(@RequestBody Cliente cliente) {
    return clienteService.adicionar(cliente);
  }
  
  @GetMapping
  public List<Cliente> buscarTodos() {
    return clienteService.buscarTodos();
  }

  @GetMapping("/{id}")
  public Optional<Cliente> buscarPorId(@PathVariable Integer id) {
    return clienteService.buscarPorId(id);
  }

  @PutMapping("/{id}")
  public Cliente putMethodName(@PathVariable Integer id, @RequestBody Cliente cliente) {
    return clienteService.atualizar(id, cliente);
  }
  
  @DeleteMapping("/{id}")
  public void deletar(@PathVariable Integer id) {
    clienteService.deletar(id);
  }
}
