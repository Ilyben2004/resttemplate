package com.example.commandems.ws.converter;

import com.example.commandems.entity.Commande;
import com.example.commandems.ws.dto.CommandeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CommandeConverter {

    public Commande map(CommandeDto dto) {
        Commande entity = new Commande();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }

    public CommandeDto map(Commande entity) {
        CommandeDto dto = new CommandeDto();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

}
