package com.academia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.model.Instrutor;
import com.academia.repository.InstrutorRepository;

@RestController
@RequestMapping("/api/instrutores")
public class InstrutorController {
    @Autowired
    private InstrutorRepository instrutorRepository;

    @GetMapping
    public List<Instrutor> listarInstrutores() {
        return instrutorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Instrutor> buscarPorId(@PathVariable Long id) {
        return instrutorRepository.findById(id);
    }

    @PostMapping
    public Instrutor criar(@RequestBody Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    @PutMapping("/{id}")
    public Instrutor atualizar(@PathVariable Long id, @RequestBody Instrutor instrutor) {
        return instrutorRepository.findById(id)
            .map(i -> {
                i.setNome(instrutor.getNome());
                i.setEspecialidade(instrutor.getEspecialidade());
                return instrutorRepository.save(i);
            })
            .orElseThrow(() -> new RuntimeException("Instrutor não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        instrutorRepository.deleteById(id);
    }

    @GetMapping("/lista")
    public java.util.List<Instrutor> listarTodos() {
        return instrutorRepository.findAll();
    }
}
