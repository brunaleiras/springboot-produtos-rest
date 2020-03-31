package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping(value = "/todos", produces = "application/json")
    public List<Produto> getProdutos(){
        List<Produto> listaProduto = new ArrayList();

        Iterable<Produto> it = produtoRepository.findAll();
        it.forEach(listaProduto::add);

        return listaProduto;
    }

    @GetMapping(value = "/produto/{id}", produces = "application/json")
    public Optional<Produto> getProdutoById(@PathVariable("id") Long id){

        return produtoRepository.findById(id);

    }

    @PostMapping(value = "/gravar", produces = "application/json")
    public Produto gravarProduto(Produto produto){

        if(produto != null ){

            return produtoRepository.save(produto);
        }else{

            return produto;

        }

    }

    @PutMapping(value = "/atualizar", produces = "application/json", consumes = "application/json")
    public Produto alterarProduto(Produto produto){

        Produto produtoPersistencia = produtoRepository.findById(produto.getId()).get();

        if(produtoPersistencia != null){

            produtoPersistencia.setValor(produto.getValor());
            produtoPersistencia.setQuantidade(produto.getQuantidade());
            produtoPersistencia.setNome(produto.getNome());

            produtoRepository.save(produtoPersistencia);
        }

        return produtoPersistencia;

    }

    @DeleteMapping
    public Long removerProduto(Produto produto){

        produtoRepository.deleteById(produto.getId());

        return produto.getId();
    }


}
