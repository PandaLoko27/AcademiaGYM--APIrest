package com.academia.controller;

import com.academia.model.Treino;
import com.academia.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {
    @Autowired
    private TreinoRepository treinoRepository;

    @GetMapping
    public List<Treino> listarTreinos() {
        return treinoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Treino> buscarPorId(@PathVariable Long id) {
        return treinoRepository.findById(id);
    }

    @PostMapping
    public Treino criar(@RequestBody Treino treino) {
        return treinoRepository.save(treino);
    }

    @PutMapping("/{id}")
    public Treino atualizar(@PathVariable Long id, @RequestBody Treino treino) {
        return treinoRepository.findById(id)
            .map(t -> {
                t.setDescricao(treino.getDescricao());
                t.setAluno(treino.getAluno());
                t.setInstrutor(treino.getInstrutor());
                return treinoRepository.save(t);
            })
            .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        treinoRepository.deleteById(id);
    }
}
