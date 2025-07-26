package com.academia.model;

import jakarta.persistence.*;

@Entity
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Instrutor instrutor;

    // getters e setters
}
