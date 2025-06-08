package com.unifood.entregador.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class PedidoClient {

    private final RestTemplate restTemplate;

    @Value("${pedido.service.url}")
    private String pedidoServiceUrl;

    public PedidoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void associarEntregador(String pedidoId, String entregadorId) throws RestClientException {
        String url = String.format("%s/api/pedidos/%s/entregador/%s", pedidoServiceUrl, pedidoId, entregadorId);
        restTemplate.put(url, null);
    }
}
