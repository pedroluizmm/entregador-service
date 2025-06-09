package com.unifood.entregador;

import com.unifood.entregador.model.Entregador;
import com.unifood.entregador.service.EntregadorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EntregadorServiceApplicationTests {

    @Autowired
    private EntregadorService entregadorService;

    @Test
    void testCriarBuscarEntregador() {
        Entregador e = new Entregador();
        e.setNome("Teste");
        e.setVeiculo("Bicicleta");
        e.setRg("12.345.678-9");
        e.setCnh("A1234567");
        e.setSeguroVeiculo("SeguroXYZ");
        e.setContaBancaria("00012345678");

        Entregador salvo = entregadorService.cadastrarEntregador(e);
        assertNotNull(salvo.getId());

        Entregador buscado = entregadorService.buscarPorId(salvo.getId());
        assertEquals("Teste", buscado.getNome());
        assertTrue(buscado.getDisponivel());
    }
}
