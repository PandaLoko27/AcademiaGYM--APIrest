package com.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Plano;
import com.academia.repository.PlanoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {
    @Autowired
    private PlanoRepository planoRepository;

    @GetMapping
    public ResponseEntity<List<Plano>> listarPlanos() {
        List<Plano> planos = planoRepository.findAll();
        return ResponseEntity.ok(planos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plano> buscarPorId(@PathVariable Long id) {
        return planoRepository.findById(id)
            .map(plano -> ResponseEntity.ok(plano))
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Plano> criar(@RequestBody @Valid Plano plano) {
        Plano novoPlano = planoRepository.save(plano);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPlano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> atualizar(@PathVariable Long id, @RequestBody @Valid Plano plano) {
        return planoRepository.findById(id)
            .map(planoExistente -> {
                planoExistente.setNome(plano.getNome());
                planoExistente.setValorMensal(plano.getValorMensal());
                return ResponseEntity.ok(planoRepository.save(planoExistente));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (planoRepository.existsById(id)) {
            planoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
