package com.produtos.apirest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.produtos.apirest.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{


}
