package com.example.paiementms.ws.converter;

import com.example.paiementms.entity.Paiement;
import com.example.paiementms.ws.dto.PaiementDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PaiementConverter {

    public Paiement map(PaiementDto dto) {
        Paiement entity = new Paiement();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public PaiementDto map(Paiement entity) {
        PaiementDto dto = new PaiementDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
