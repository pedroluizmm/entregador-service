package com.unifood.entregador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AtribuirEntregaResponse {
    private Long entregaId;
    private Long entregadorId;
    private String status;
}
