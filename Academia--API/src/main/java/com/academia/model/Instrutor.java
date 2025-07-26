package com.academia.model;

import jakarta.persistence.*;

@Entity
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String especialidade;

    // getters e setters
}
