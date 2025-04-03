package com.formacion.motos.entidades;

import com.formacion.motos.entidades.api.Address;
import com.formacion.motos.entidades.api.Bank;
import com.formacion.motos.entidades.api.Company;
import com.formacion.motos.entidades.api.Crypto;
import com.formacion.motos.entidades.api.Hair;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "User")
@Data
public class User {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private double height;
    private double weight;
    private String eyeColor;
    private String ip;
    private String macAddress;
    private String university;
    private String ein;
    private String ssn;
    private String userAgent;
    private String role;

    @Embedded
    private Hair hair;

    @Embedded
    private Address address;

    @Embedded
    private Company company;

    @Embedded
    private Bank bank;

    @Embedded
    private Crypto crypto;
}
