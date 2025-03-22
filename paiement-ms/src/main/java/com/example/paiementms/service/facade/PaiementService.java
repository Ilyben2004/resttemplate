package com.example.paiementms.service.facade;

import com.example.paiementms.entity.Paiement;

import java.util.List;

public interface PaiementService {
    int save(Paiement paiement);

    Paiement findByCode(String code);

    int deleteByCode(String code);

    List<Paiement> findAll();
}
