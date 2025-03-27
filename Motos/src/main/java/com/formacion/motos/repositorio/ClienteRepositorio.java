package com.formacion.motos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.motos.entidades.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer> {
	
    Cliente findByNombre(String nombre); // Buscar cliente por su nombre
    
}

