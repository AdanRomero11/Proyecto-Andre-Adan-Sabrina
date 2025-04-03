package com.formacion.motos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.motos.entidades.UsuarioApi;


public interface UsuarioApiRepository extends JpaRepository<UsuarioApi, Long> {
}
