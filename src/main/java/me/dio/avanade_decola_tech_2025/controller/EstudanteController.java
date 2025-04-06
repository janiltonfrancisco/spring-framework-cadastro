package me.dio.avanade_decola_tech_2025.controller;

import me.dio.avanade_decola_tech_2025.domain.Estudante;
import me.dio.avanade_decola_tech_2025.repository.EstudanteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudantes")
public class EstudanteController {

    private final EstudanteRepository repository;

    public EstudanteController(EstudanteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Estudante> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudante> buscarPorId(@PathVariable Long id) {
        Optional<Estudante> estudante = repository.findById(id);
        return estudante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudante> criar(@RequestBody Estudante estudante) {
        Estudante salvo = repository.save(estudante);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(salvo.getId())
                .toUri();
        return ResponseEntity.created(location).body(salvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudante> atualizar(@PathVariable Long id, @RequestBody Estudante estudante) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        estudante.setId(id);
        Estudante atualizado = repository.save(estudante);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}