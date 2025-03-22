package com.example.commandems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Commande {
    @Id @GeneratedValue
    private Long id;
    private String ref;
    private BigDecimal total;
    private BigDecimal totalPaye;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalPaye() {
        return totalPaye;
    }

    public void setTotalPaye(BigDecimal totalPaye) {
        this.totalPaye = totalPaye;
    }
}
