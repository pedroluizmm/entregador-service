package com.unifood.entregador.service;

import com.unifood.entregador.model.AtribuicaoEntrega;
import com.unifood.entregador.model.Entregador;
import com.unifood.entregador.model.StatusEntrega;
import com.unifood.entregador.repository.AtribuicaoEntregaRepository;
import com.unifood.entregador.repository.EntregadorRepository;
import com.unifood.entregador.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    private final EntregadorRepository entregadorRepository;
    private final AtribuicaoEntregaRepository atribuicaoRepository;

    @Autowired
    public EntregaService(EntregadorRepository entregadorRepository,
                          AtribuicaoEntregaRepository atribuicaoRepository) {
        this.entregadorRepository = entregadorRepository;
        this.atribuicaoRepository = atribuicaoRepository;
    }

    public AtribuicaoEntrega atribuirEntregadorAoPedido(String orderId) {
        List<Entregador> disponiveis = entregadorRepository.findByDisponivelTrue();
        if (disponiveis.isEmpty()) {
            throw new IllegalStateException("Nenhum entregador disponível");
        }
        Entregador entregador = disponiveis.get(new java.util.Random().nextInt(disponiveis.size()));

        entregador.setDisponivel(false);
        entregadorRepository.save(entregador);

        AtribuicaoEntrega atrib = new AtribuicaoEntrega();
        atrib.setOrderId(orderId);
        atrib.setEntregadorId(entregador.getId());
        atrib.aoCriar();
        return atribuicaoRepository.save(atrib);
    }

    public AtribuicaoEntrega atualizarStatusEntrega(String entregaId, StatusEntrega novoStatus) {
        AtribuicaoEntrega atrib = atribuicaoRepository.findById(entregaId)
                .orElseThrow(() -> new ResourceNotFoundException("Atribuição não encontrada: " + entregaId));

        if (novoStatus == StatusEntrega.EM_ROTA) {
            atrib.setStatus(StatusEntrega.EM_ROTA);
            atribuicaoRepository.save(atrib);

        } else if (novoStatus == StatusEntrega.ENTREGUE) {
            atrib.setStatus(StatusEntrega.ENTREGUE);
            atribuicaoRepository.save(atrib);

            Entregador entregador = entregadorRepository.findById(atrib.getEntregadorId())
                    .orElseThrow(() -> new ResourceNotFoundException("Entregador não encontrado: " + atrib.getEntregadorId()));
            entregador.setDisponivel(true);
            entregadorRepository.save(entregador);

        } else {
            throw new IllegalArgumentException("Status inválido: " + novoStatus);
        }
        return atrib;
    }

    public List<AtribuicaoEntrega> listarAtribuicoesPorEntregador(String entregadorId) {
        if (!entregadorRepository.existsById(entregadorId)) {
            throw new ResourceNotFoundException("Entregador não encontrado: " + entregadorId);
        }
        return atribuicaoRepository.findByEntregadorIdAndStatusNot(entregadorId, StatusEntrega.ENTREGUE);
    }

    public List<AtribuicaoEntrega> listarEntregasAtivas() {
        return atribuicaoRepository.findByStatusNot(StatusEntrega.ENTREGUE);
    }
}
