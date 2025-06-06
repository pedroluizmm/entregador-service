package com.unifood.entregador.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import com.unifood.entregador.model.StatusEntrega;

@Getter
@Setter
public class AtualizarStatusEntregaRequest {
    @NotNull(message = "O campo status é obrigatório e deve ser um dos valores definidos em StatusEntrega")
    private StatusEntrega status;
}
