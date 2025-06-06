package com.unifood.entregador.service;

import com.unifood.entregador.model.AtribuicaoEntrega;
import com.unifood.entregador.model.Entregador;
import com.unifood.entregador.repository.AtribuicaoEntregaRepository;
import com.unifood.entregador.repository.EntregadorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntregaService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Autowired
    private AtribuicaoEntregaRepository atribuicaoRepository;

    @Transactional
    public AtribuicaoEntrega atribuirEntregadorAoPedido(String orderId) {
        Entregador entregador = entregadorRepository.findByDisponivelTrue()
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Nenhum entregador dispon\u00edvel"));

        entregador.setDisponivel(false);
        entregadorRepository.save(entregador);

        AtribuicaoEntrega atrib = new AtribuicaoEntrega();
        atrib.setOrderId(orderId);
        atrib.setEntregadorId(entregador.getId());
        AtribuicaoEntrega salva = atribuicaoRepository.save(atrib);
        return salva;
    }

    @Transactional
    public AtribuicaoEntrega atualizarStatusEntrega(Long entregaId, String novoStatus) {
        AtribuicaoEntrega atrib = atribuicaoRepository.findById(entregaId)
                .orElseThrow(() -> new EntityNotFoundException("Atribui\u00e7\u00e3o n\u00e3o encontrada: " + entregaId));

        if ("EM_ROTA".equals(novoStatus)) {
            atrib.setStatus("EM_ROTA");
            atribuicaoRepository.save(atrib);
        } else if ("ENTREGUE".equals(novoStatus)) {
            atrib.setStatus("ENTREGUE");
            atribuicaoRepository.save(atrib);

            Entregador entregador = entregadorRepository.findById(atrib.getEntregadorId())
                    .orElseThrow(() -> new EntityNotFoundException("Entregador n\u00e3o encontrado: " + atrib.getEntregadorId()));
            entregador.setDisponivel(true);
            entregadorRepository.save(entregador);
        } else {
            throw new IllegalArgumentException("Status inv\u00e1lido: " + novoStatus);
        }
        return atrib;
    }

    public List<AtribuicaoEntrega> listarAtribuicoesPorEntregador(Long entregadorId) {
        if (!entregadorRepository.existsById(entregadorId)) {
            throw new EntityNotFoundException("Entregador n\u00e3o encontrado: " + entregadorId);
        }
        return atribuicaoRepository.findByEntregadorIdAndStatusNot(entregadorId, "ENTREGUE");
    }
}
