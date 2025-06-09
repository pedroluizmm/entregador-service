package com.unifood.entregador.repository;

import com.unifood.entregador.model.AtribuicaoEntrega;
import com.unifood.entregador.model.StatusEntrega;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtribuicaoEntregaRepository extends MongoRepository<AtribuicaoEntrega, String> {
    List<AtribuicaoEntrega> findByEntregadorIdAndStatusNot(String entregadorId, StatusEntrega status);
    List<AtribuicaoEntrega> findByStatusNot(StatusEntrega status);
}
