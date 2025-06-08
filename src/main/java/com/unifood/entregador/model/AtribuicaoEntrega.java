package com.unifood.entregador.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "atribuicoes_entrega")
public class AtribuicaoEntrega {

    @Id
    private String id;

    private String orderId;
    private String entregadorId;

    private StatusEntrega status;

    @CreatedDate
    private LocalDateTime atribuidoEm;

    @LastModifiedDate
    private LocalDateTime atualizadoEm;

    public AtribuicaoEntrega() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public String getEntregadorId() {
        return entregadorId;
    }

    public void setEntregadorId(String entregadorId) {
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

    public void aoCriar() {
        if (this.status == null) {
            this.status = StatusEntrega.PENDENTE;
        }
    }
}
