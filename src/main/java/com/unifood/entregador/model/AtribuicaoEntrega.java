package com.unifood.entregador.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.unifood.entregador.model.StatusEntrega;

import java.time.LocalDateTime;

@Entity
@Table(name = "atribuicoes_entrega")
@Getter
@Setter
@NoArgsConstructor
public class AtribuicaoEntrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private Long entregadorId;

    @Enumerated(EnumType.STRING)
    private StatusEntrega status;

    private LocalDateTime atribuidoEm;
    private LocalDateTime atualizadoEm;

    @PrePersist
    public void aoCriar() {
        this.atribuidoEm = LocalDateTime.now();
        this.atualizadoEm = LocalDateTime.now();
        if (this.status == null) {
            this.status = StatusEntrega.PENDENTE;
        }
    }

    @PreUpdate
    public void aoAtualizar() {
        this.atualizadoEm = LocalDateTime.now();
    }
}
