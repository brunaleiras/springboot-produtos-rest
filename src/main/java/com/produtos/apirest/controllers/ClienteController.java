package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Compra;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ClienteRepository;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PutMapping(value = "/", produces = "application/json", consumes = "application/json")
    public Cliente alterarCliente(@RequestBody Cliente cliente){

        Cliente clientePersistencia = clienteRepository.findById(cliente.getId()).get();

        if(clientePersistencia != null){

            clientePersistencia.setNome(cliente.getNome());

            clienteRepository.save(clientePersistencia);
        }

        return clientePersistencia;

    }


    @GetMapping(value = "/", produces = "application/json")
    public List<Cliente> getTodosOsClientes(){

        List<Cliente> todosClientes = clienteRepository.findAll();

        return todosClientes;

    }

    //@PostMapping
    @GetMapping(value = "/popula", produces = "application/json")
    public Cliente populaCliente(){

        Produto p01 = new Produto();
        p01.setId(1L);
        p01.setNome("alcool em gel");
        p01.setQuantidade(new BigDecimal(123));
        p01.setValor(new BigDecimal((66)));


        Produto p02 = new Produto();
        p02.setId(2L);
        p02.setNome("mascara de oxigenio");
        p02.setQuantidade(new BigDecimal(998));
        p02.setValor(new BigDecimal((86)));

        Produto p03 = new Produto();
        p03.setId(3L);
        p03.setNome("luvas de protecao");
        p03.setQuantidade(new BigDecimal(3444));
        p03.setValor(new BigDecimal((12)));


        produtoRepository.save(p01);
        produtoRepository.save(p02);
        produtoRepository.save(p03);

        Cliente cliente = new Cliente();
        cliente.setNome("jose");

        List<Compra> compras = new ArrayList<Compra>();

        Compra compra = new Compra();

        List<Produto> produtos = new ArrayList<Produto>();

        Produto p1  = produtoRepository.findById(1L).get();
        Produto p2  = produtoRepository.findById(2L).get();

        produtos.add(p1);
        produtos.add(p2);

        compra.setProdutos(produtos);

        compras.add(compra);

        cliente.setCompras(compras);

        return this.clienteRepository.save(cliente);

    }


}
