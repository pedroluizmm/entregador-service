package com.unifood.entregador.controller;

import com.unifood.entregador.dto.AtribuirEntregaResponse;
import com.unifood.entregador.dto.EntregadorDTO;
import com.unifood.entregador.model.AtribuicaoEntrega;
import com.unifood.entregador.model.Entregador;
import com.unifood.entregador.service.EntregaService;
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

    @Autowired
    private EntregaService entregaService;

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

    @GetMapping
    public ResponseEntity<List<Entregador>> listarTodos() {
        return ResponseEntity.ok(entregadorService.listarTodos());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Entregador>> listarDisponiveis() {
        return ResponseEntity.ok(entregadorService.listarEntregadoresDisponiveis());
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Entregador> atualizarDisponibilidade(
            @PathVariable String id,
            @RequestParam Boolean disponivel) {
        try {
            return ResponseEntity.ok(entregadorService.atualizarDisponibilidade(id, disponivel));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregador> buscarPorId(@PathVariable String id) {
        try {
            return ResponseEntity.ok(entregadorService.buscarPorId(id));
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/assign/{orderId}")
    public ResponseEntity<AtribuirEntregaResponse> atribuirAleatorio(
            @PathVariable String orderId) {
        try {
            AtribuicaoEntrega atrib = entregaService.atribuirEntregadorAoPedido(orderId);
            AtribuirEntregaResponse resp = new AtribuirEntregaResponse(
                    atrib.getId(),
                    atrib.getEntregadorId(),
                    atrib.getOrderId(),
                    atrib.getStatus()
            );
            return ResponseEntity.ok(resp);
        } catch (IllegalStateException ex) {
            return ResponseEntity.status(503).build();
        }
    }
}
