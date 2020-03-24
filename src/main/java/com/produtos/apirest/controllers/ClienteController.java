package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("clienterest")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    //@PostMapping
    @GetMapping(value = "/cliente", produces = "application/json")
    public Cliente postCliente(){

        Cliente cliente = new Cliente();
        cliente.setNome("jose");
        cliente.setTelefone("999-999");
        cliente.setEmail("email@email.com");
        return this.clienteRepository.save(cliente);


    }


}
