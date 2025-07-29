package com.academia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.model.Treino;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
}
