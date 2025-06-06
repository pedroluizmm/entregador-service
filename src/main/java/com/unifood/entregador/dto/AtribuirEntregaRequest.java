package com.unifood.entregador.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class AtribuirEntregaRequest {
    @NotBlank
    private String orderId;
}
