package com.unifood.entregador.dto;


public class EntregadorPedidoResponse {
    private String entregadorId;
    private String orderId;

    public EntregadorPedidoResponse(String entregadorId, String orderId) {
        this.entregadorId = entregadorId;
        this.orderId = orderId;
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
}
