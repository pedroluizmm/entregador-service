package com.unifood.entregador.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.unifood.entregador.model.StatusEntrega;

@Getter
@Setter
@AllArgsConstructor
public class AtribuirEntregaResponse {
    private Long entregaId;
    private Long entregadorId;
    private StatusEntrega status;
}
