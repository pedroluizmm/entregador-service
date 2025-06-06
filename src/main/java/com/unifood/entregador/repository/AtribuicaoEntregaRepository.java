package com.unifood.entregador.repository;

import com.unifood.entregador.model.AtribuicaoEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtribuicaoEntregaRepository extends JpaRepository<AtribuicaoEntrega, Long> {
    List<AtribuicaoEntrega> findByEntregadorIdAndStatusNot(Long entregadorId, String status);
}
