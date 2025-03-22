package com.example.commandems.service.facade;

import com.example.commandems.entity.Commande;

public interface CommandeService {
    int save(Commande commande);

    int update(Commande commande);

    Commande findByRef(String ref);

    int deleteByRef(String ref);
}
