package com.unifood.entregador.controller;

import com.unifood.entregador.dto.AtribuirEntregaRequest;
import com.unifood.entregador.dto.AtribuirEntregaResponse;
import com.unifood.entregador.dto.AtualizarStatusEntregaRequest;
import com.unifood.entregador.model.AtribuicaoEntrega;
import com.unifood.entregador.service.EntregaService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
@CrossOrigin(origins = "*")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping("/assign")
    public ResponseEntity<AtribuirEntregaResponse> atribuirEntregador(
            @Valid @RequestBody AtribuirEntregaRequest request) {
        try {
            AtribuicaoEntrega atrib = entregaService.atribuirEntregadorAoPedido(request.getOrderId());
            AtribuirEntregaResponse resp = new AtribuirEntregaResponse(
                    atrib.getId(),
                    atrib.getEntregadorId(),
                    atrib.getStatus()
            );
            return ResponseEntity.ok(resp);
        } catch (IllegalStateException ex) {
            return ResponseEntity.status(503).build();
        }
    }

    @PutMapping("/{entregaId}/status")
    public ResponseEntity<AtribuicaoEntrega> atualizarStatusEntrega(
            @PathVariable String entregaId,
            @Valid @RequestBody AtualizarStatusEntregaRequest request) {
        try {
            AtribuicaoEntrega atualizada = entregaService.atualizarStatusEntrega(entregaId, request.getStatus());
            return ResponseEntity.ok(atualizada);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/deliverer/{entregadorId}/assignments")
    public ResponseEntity<List<AtribuicaoEntrega>> listarAtribuicoesPorEntregador(
            @PathVariable String entregadorId) {
        try {
            List<AtribuicaoEntrega> lista = entregaService.listarAtribuicoesPorEntregador(entregadorId);
            return ResponseEntity.ok(lista);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
