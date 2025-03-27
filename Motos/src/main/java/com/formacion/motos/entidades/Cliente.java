package com.formacion.motos.entidades;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nombre;
    private String apellido1;
    private String apellido2;
    private String calle;
    private int numero;
    private String codigoP;
    private String localidad;
    private String poblacion;
    private String telefono;
    private String email;
    private String password;
    private Date fechaRegistro;

}
