package com.unifood.entregador.repository;

import com.unifood.entregador.model.Entregador;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregadorRepository extends MongoRepository<Entregador, String> {
    List<Entregador> findByDisponivelTrue();
}
