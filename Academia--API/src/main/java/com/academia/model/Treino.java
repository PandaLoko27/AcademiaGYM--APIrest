package com.academia.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }
    public Instrutor getInstrutor() { return instrutor; }
    public void setInstrutor(Instrutor instrutor) { this.instrutor = instrutor; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
}
