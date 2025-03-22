package com.example.paiementms.dao;

import com.example.paiementms.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementDao extends JpaRepository<Paiement, Long> {

    Paiement findByCode(String code);

    int deleteByCode(String code);
}
