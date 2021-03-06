package com.produtos.apirest.repository;

import com.produtos.apirest.models.Cliente;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.boot.admin.SpringApplicationAdminMXBean;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{


}
