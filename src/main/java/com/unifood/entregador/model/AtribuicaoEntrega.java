package com.unifood.entregador.model;

import jakarta.persistence.*;

import com.unifood.entregador.model.StatusEntrega;

import java.time.LocalDateTime;

@Entity
@Table(name = "atribuicoes_entrega")
public class AtribuicaoEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private Long entregadorId;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    private LocalDateTime atribuidoEm;
    private LocalDateTime atualizadoEm;

    public AtribuicaoEntrega() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getEntregadorId() {
        return entregadorId;
    }

    public void setEntregadorId(Long entregadorId) {
        this.entregadorId = entregadorId;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public LocalDateTime getAtribuidoEm() {
        return atribuidoEm;
    }

    public void setAtribuidoEm(LocalDateTime atribuidoEm) {
        this.atribuidoEm = atribuidoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    @PrePersist
    public void aoCriar() {
        this.atribuidoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
        if (this.status == null) {
            this.status = StatusEntrega.PENDENTE;
        }
    }

    @PreUpdate
    public void aoAtualizar() {
        this.atualizadoEm = LocalDateTime.now();
    }
}
