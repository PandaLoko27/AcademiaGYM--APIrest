package com.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.exception.BadRequestException;
import com.academia.model.Aluno;
import com.academia.repository.AlunoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alunos")
@Validated
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoRepository.findById(id)
            .map(aluno -> ResponseEntity.ok(aluno))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody @Valid Aluno aluno) {
        try {
            Aluno novoAluno = alunoRepository.save(aluno);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
        } catch (DataIntegrityViolationException e) {
            throw new BadRequestException("Email já cadastrado");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody @Valid Aluno aluno) {
        return alunoRepository.findById(id)
            .map(alunoExistente -> {
                alunoExistente.setNome(aluno.getNome());
                alunoExistente.setEmail(aluno.getEmail());
                alunoExistente.setDataNascimento(aluno.getDataNascimento());
                alunoExistente.setPlano(aluno.getPlano());
                return ResponseEntity.ok(alunoRepository.save(alunoExistente));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
