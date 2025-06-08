package com.unifood.entregador.controller;

import com.unifood.entregador.dto.EntregadorDTO;
import com.unifood.entregador.model.Entregador;
import com.unifood.entregador.service.EntregadorService;
import com.unifood.entregador.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregadores")
@CrossOrigin(origins = "*")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @PostMapping
    public ResponseEntity<Entregador> cadastrarEntregador(@Valid @RequestBody EntregadorDTO dto) {
        Entregador e = new Entregador();
        e.setNome(dto.getNome());
        e.setVeiculo(dto.getVeiculo());
        e.setRg(dto.getRg());
        e.setCnh(dto.getCnh());
        e.setSeguroVeiculo(dto.getSeguroVeiculo());
        e.setContaBancaria(dto.getContaBancaria());
        Entregador criado = entregadorService.cadastrarEntregador(e);
        return ResponseEntity.ok(criado);
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Entregador>> listarDisponiveis() {
        List<Entregador> lista = entregadorService.listarEntregadoresDisponiveis();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Entregador> atualizarDisponibilidade(
            @PathVariable String id,
            @RequestParam Boolean disponivel) {
        try {
            Entregador atualizado = entregadorService.atualizarDisponibilidade(id, disponivel);
            return ResponseEntity.ok(atualizado);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregador> buscarPorId(@PathVariable String id) {
        try {
            Entregador e = entregadorService.buscarPorId(id);
            return ResponseEntity.ok(e);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
