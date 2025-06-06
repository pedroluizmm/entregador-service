package com.unifood.entregador.dto;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;

@Getter
@Setter
public class EntregadorDTO {
    @NotBlank
    private String nome;

    @NotBlank
    private String veiculo;

    @NotBlank
    private String rg;

    @NotBlank
    private String cnh;

    @NotBlank
    private String seguroVeiculo;

    @NotBlank
    private String contaBancaria;
}
