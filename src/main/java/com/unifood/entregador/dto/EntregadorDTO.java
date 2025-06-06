package com.unifood.entregador.dto;

import jakarta.validation.constraints.NotBlank;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getSeguroVeiculo() {
        return seguroVeiculo;
    }

    public void setSeguroVeiculo(String seguroVeiculo) {
        this.seguroVeiculo = seguroVeiculo;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }
}
