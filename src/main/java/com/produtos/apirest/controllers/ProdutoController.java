package com.produtos.apirest.controllers;

import com.produtos.apirest.models.Cliente;
import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApiOperation(value = "Webservice de produtos")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Resposta OK"),
        @ApiResponse(code = 500, message = "Ocorreu um erro na API"),
        @ApiResponse(code = 403, message = "Sem premissão"),
})
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
    public Optional<Produto> getProdutoById(@ApiParam(
            name =  "id",
            type = "Long",
            value = "Digite um id de produto",
            example = "1",
            required = true) @PathVariable("id") Long id){

        return produtoRepository.findById(id);

    }

    @GetMapping(value = "/", produces = "application/json")
    public List<Produto> getListaProdutos(){

        return produtoRepository.findAll();

    }

    @GetMapping
    public List<Produto> getListaProdutosCentral(){

        return produtoRepository.findAll();

    }

    @PostMapping(value = "/gravar", produces = "application/json")
    public Produto gravarProduto(Produto produto){

        if(produto != null ){

            return produtoRepository.save(produto);
        }else{

            return produto;

        }

    }

    @PutMapping(value = "/atualizar", produces = "application/json")
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
