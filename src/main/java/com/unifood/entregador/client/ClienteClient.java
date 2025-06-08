package com.unifood.entregador.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClienteClient {

    private final RestTemplate restTemplate;

    @Value("${cliente.service.url}")
    private String clienteServiceUrl;

    public ClienteClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String buscarNomeCliente(String clienteId) {
        String url = String.format("%s/api/clientes/%s", clienteServiceUrl, clienteId);
        ResponseEntity<ClienteResponse> response = restTemplate.getForEntity(url, ClienteResponse.class);
        ClienteResponse body = response.getBody();
        return body != null ? body.getNome() : null;
    }

    public static class ClienteResponse {
        private String id;
        private String nome;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
