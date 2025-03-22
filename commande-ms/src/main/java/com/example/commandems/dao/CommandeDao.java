package com.example.commandems.dao;

import com.example.commandems.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Long> {
    Commande findByRef(String ref);

    int deleteByRef(String ref);
}
