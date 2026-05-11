package com.example.baozirest.controller;

import com.example.baozirest.model.Cliente;
import com.example.baozirest.repository.ClienteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente") // Conforme definido no seu arquivo original
public class ClienteController {

    private final ClienteRepository repository;

    // Injeção via construtor (Boa prática)
    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    // GET – listar todos
    @GetMapping
    public List<Cliente> findAll() {
        return repository.findAll();
    }

    // GET /{id} – consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST – criar
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    // PUT /{id} – atualização
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente) {
        return repository.findById(id)
                .map(record -> {
                    record.setNome(cliente.getNome());
                    record.setClienteDesde(cliente.getClienteDesde());
                    Cliente updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /{id} – apagar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}