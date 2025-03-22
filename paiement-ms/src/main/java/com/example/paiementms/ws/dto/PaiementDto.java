package com.example.paiementms.ws.dto;

import java.math.BigDecimal;

public class PaiementDto {
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
