package com.unifood.entregador.dto;

import jakarta.validation.constraints.NotBlank;

public class AtribuirEntregaRequest {
    @NotBlank
    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
