package com.formacion.motos.entidades.api;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Company {
    private String department;
    private String name;
    private String title;
}
