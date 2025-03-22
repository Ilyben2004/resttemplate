package com.example.paiementms.service.impl;

import com.example.paiementms.dao.PaiementDao;
import com.example.paiementms.entity.Paiement;
import com.example.paiementms.service.facade.PaiementService;
import com.example.paiementms.service.requiered.CommandeRequired;
import com.example.paiementms.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PaiementServiceImpl implements PaiementService {
    @Autowired
    private PaiementDao dao;
    @Autowired
    private CommandeRequired commandeRequired;

    //c1 : 100, 10 --- paiement: c1 95 -->
    @Override
    public int save(Paiement paiement) {
        if (dao.findByCode(paiement.getCode()) != null) {
            return -1;
        } else {
            CommandeDto commandeDto = commandeRequired.findByRef(paiement.getCommandeRef());
            if (commandeDto == null || commandeDto.getId() == null) {
                return -2;
            }
            BigDecimal nvTotalPaye = commandeDto.getTotalPaye().add(paiement.getMontant());
            if (commandeDto.getTotal().compareTo(nvTotalPaye) < 0) {
                return -3;
            } else {
                commandeDto.setTotalPaye(nvTotalPaye);
                int updated = commandeRequired.update(commandeDto);
                if (updated > 0) {
                    dao.save(paiement);
                    return 1;
                } else {
                    return -4;
                }
            }
        }
    }

    @Override
    public Paiement findByCode(String code) {
        return dao.findByCode(code);
    }

    @Override
    @Transactional
    public int deleteByCode(String code) {
        return dao.deleteByCode(code);
    }

    @Override
    public List<Paiement> findAll() {
        return dao.findAll();
    }
}
