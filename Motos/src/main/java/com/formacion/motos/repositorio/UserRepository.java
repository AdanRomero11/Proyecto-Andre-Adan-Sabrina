package com.formacion.motos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.motos.entidades.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
