package com.unifood.entregador.dto;

import com.unifood.entregador.model.StatusEntrega;

public class AtribuirEntregaResponse {
    private String entregaId;
    private String entregadorId;
    private String orderId;
    private StatusEntrega status;

    public AtribuirEntregaResponse(String entregaId, String entregadorId, String orderId, StatusEntrega status) {
        this.entregaId = entregaId;
        this.entregadorId = entregadorId;
        this.orderId = orderId;
        this.status = status;
    }

    public String getEntregaId() {
        return entregaId;
    }

    public void setEntregaId(String entregaId) {
        this.entregaId = entregaId;
    }

    public String getEntregadorId() {
        return entregadorId;
    }

    public void setEntregadorId(String entregadorId) {
        this.entregadorId = entregadorId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }
}
