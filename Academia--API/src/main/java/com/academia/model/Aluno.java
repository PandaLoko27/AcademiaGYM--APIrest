package com.academia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    @ManyToOne
    private Plano plano;

    @OneToMany(mappedBy = "aluno")
    private List<Treino> treinos;

    // getters e setters
}
