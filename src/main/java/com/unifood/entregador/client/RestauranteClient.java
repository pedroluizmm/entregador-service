package com.unifood.entregador.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class RestauranteClient {

    private final RestTemplate restTemplate;

    @Value("${restaurante.service.url}")
    private String restauranteServiceUrl;

    public RestauranteClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ItemCardapioResponse> listarItensCardapio() {
        String url = restauranteServiceUrl + "/itensCardapio";
        ResponseEntity<ItemCardapioResponse[]> response = restTemplate.getForEntity(url, ItemCardapioResponse[].class);
        ItemCardapioResponse[] body = response.getBody();
        return body != null ? Arrays.asList(body) : List.of();
    }

    public static class ItemCardapioResponse {
        private String id;
        private String nome;
        private String descricao;
        private Double preco;
        private String restauranteId;

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getNome() { return nome; }
        public void setNome(String nome) { this.nome = nome; }
        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }
        public Double getPreco() { return preco; }
        public void setPreco(Double preco) { this.preco = preco; }
        public String getRestauranteId() { return restauranteId; }
        public void setRestauranteId(String restauranteId) { this.restauranteId = restauranteId; }
    }
}
