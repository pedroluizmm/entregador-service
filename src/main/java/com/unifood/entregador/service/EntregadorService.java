package com.unifood.entregador.service;

import com.unifood.entregador.model.Entregador;
import com.unifood.entregador.repository.EntregadorRepository;
import com.unifood.entregador.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    private final EntregadorRepository entregadorRepository;

    @Autowired
    public EntregadorService(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }

    public Entregador cadastrarEntregador(Entregador entregador) {
        entregador.aoCriar();
        return entregadorRepository.save(entregador);
    }

    public List<Entregador> listarTodos() {
        return entregadorRepository.findAll();
    }

    public List<Entregador> listarEntregadoresDisponiveis() {
        return entregadorRepository.findByDisponivelTrue();
    }

    public Entregador atualizarDisponibilidade(String id, Boolean disponivel) {
        Entregador e = entregadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entregador n\u00e3o encontrado: " + id));
        e.setDisponivel(disponivel);
        return entregadorRepository.save(e);
    }

    public Entregador buscarPorId(String id) {
        return entregadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Entregador n\u00e3o encontrado: " + id));
    }
}
