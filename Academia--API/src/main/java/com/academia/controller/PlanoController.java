package com.academia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Plano> listarPlanos() {
        return planoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Plano> buscarPorId(@PathVariable Long id) {
        return planoRepository.findById(id);
    }

    @PostMapping
    public Plano criar(@RequestBody Plano plano) {
        return planoRepository.save(plano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plano> atualizar(@PathVariable Long id, @RequestBody @Valid Plano plano) {
        return planoRepository.findById(id)
            .map(p -> {
                p.setNome(plano.getNome());
                p.setValorMensal(plano.getValorMensal());
                return ResponseEntity.ok(planoRepository.save(p));
            })
            .orElseThrow(() -> new RuntimeException("Plano não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        planoRepository.deleteById(id);
    }
}
