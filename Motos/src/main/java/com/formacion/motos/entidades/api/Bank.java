package com.formacion.motos.entidades.api;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class Bank {
    private String cardExpire;
    private String cardNumber;
    private String cardType;
    private String currency;
    private String iban;
}
