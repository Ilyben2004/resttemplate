package com.example.paiementms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Paiement {
    @Id @GeneratedValue
    private Long id;
    private BigDecimal montant;
    private String code;
    private String commandeRef;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCommandeRef() {
        return commandeRef;
    }

    public void setCommandeRef(String commandeRef) {
        this.commandeRef = commandeRef;
    }
}
