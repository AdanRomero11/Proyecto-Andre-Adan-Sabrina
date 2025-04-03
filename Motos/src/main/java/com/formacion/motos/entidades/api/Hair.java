package com.formacion.motos.entidades.api;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Hair {
    private String color;
    private String type;
}
