package com.unifood.entregador.dto;

import lombok.Getter;
import lombok.Setter;

import com.unifood.entregador.model.StatusEntrega;

@Getter
@Setter
public class AtualizarStatusEntregaRequest {
    private StatusEntrega status;
}
