package com.example.commandems.service.impl;

import com.example.commandems.dao.CommandeDao;
import com.example.commandems.entity.Commande;
import com.example.commandems.service.facade.CommandeService;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao dao;

    @Override
    public int save(Commande commande) {
        if (findByRef(commande.getRef()) != null) {
            return -1;
        } else {
            dao.save(commande);
            return 1;
        }
    }
    @Override
    public int update(Commande commande) {
        Commande loadeCommande = findByRef(commande.getRef());
        if (loadeCommande == null) {
            return -1;
        } else {
            dao.save(commande);
            return 1;
        }
    }

    @Override
    public Commande findByRef(String ref) {
        return dao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return dao.deleteByRef(ref);
    }

    public List<Commande> findAll() {
        return dao.findAll();
    }
}
