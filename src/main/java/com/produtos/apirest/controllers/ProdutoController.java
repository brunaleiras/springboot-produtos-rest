package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apirest")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    //@RequestMapping(name="/produtos", method = RequestMethod.GET)
    @GetMapping(value = "/produtos", produces = "application/json")
    public List<Produto> getProdutos(){
        List<Produto> listaProduto = new ArrayList();

        Iterable<Produto> it = produtoRepository.findAll();

        it.forEach(listaProduto::add);

        return listaProduto;

    }

    public Produto getProdutoById(Long id){

        Produto produto = new Produto();

        return produto;


    }



}
