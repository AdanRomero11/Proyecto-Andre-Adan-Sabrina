package com.formacion.motos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.motos.entidades.Cliente;
import java.util.List;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	
    Cliente findByEmail(String email); // Buscar cliente por su email
    
}

