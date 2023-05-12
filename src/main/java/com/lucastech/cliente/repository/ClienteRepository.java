package com.lucastech.cliente.repository;

import com.lucastech.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
