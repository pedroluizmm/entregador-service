package com.unifood.entregador.dto;

import jakarta.validation.constraints.NotNull;
import com.unifood.entregador.model.StatusEntrega;

public class AtualizarStatusEntregaRequest {
    @NotNull(message = "O campo status é obrigatório e deve ser um dos valores definidos em StatusEntrega")
    private StatusEntrega status;

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }
}
