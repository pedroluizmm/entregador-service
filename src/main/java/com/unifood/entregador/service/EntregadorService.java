package com.unifood.entregador.service;

import com.unifood.entregador.model.Entregador;
import com.unifood.entregador.repository.EntregadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    public Entregador cadastrarEntregador(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public List<Entregador> listarEntregadoresDisponiveis() {
        return entregadorRepository.findByDisponivelTrue();
    }

    public Entregador atualizarDisponibilidade(Long id, Boolean disponivel) {
        Entregador e = entregadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entregador n\u00e3o encontrado: " + id));
        e.setDisponivel(disponivel);
        return entregadorRepository.save(e);
    }

    public Entregador buscarPorId(Long id) {
        return entregadorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entregador n\u00e3o encontrado: " + id));
    }
}
