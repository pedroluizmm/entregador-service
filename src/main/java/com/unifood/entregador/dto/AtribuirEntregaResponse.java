package com.unifood.entregador.dto;


import com.unifood.entregador.model.StatusEntrega;

public class AtribuirEntregaResponse {
    private Long entregaId;
    private Long entregadorId;
    private StatusEntrega status;

    public AtribuirEntregaResponse(Long entregaId, Long entregadorId, StatusEntrega status) {
        this.entregaId = entregaId;
        this.entregadorId = entregadorId;
        this.status = status;
    }

    public Long getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(Long entregaId) {
        this.entregaId = entregaId;
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
}
