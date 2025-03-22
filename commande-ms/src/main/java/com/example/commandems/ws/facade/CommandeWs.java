package com.example.commandems.ws.facade;

import com.example.commandems.entity.Commande;
import com.example.commandems.service.facade.CommandeService;
import com.example.commandems.service.impl.WordUpdater;
import com.example.commandems.ws.converter.CommandeConverter;
import com.example.commandems.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/commande/")
public class CommandeWs {
    @Autowired
    private CommandeService service;
    @Autowired
    private CommandeConverter converter;
    @Autowired
    private WordUpdater wordUpdater;

/*
    @PostMapping("")
    public int save(@RequestBody CommandeDto dto) {
        Commande commande = converter.map(dto);
        return service.save(commande);
    }*/

    @GetMapping("replace")
    public void replace() {
        wordUpdater.replace();
    }

    @PostMapping("")
    public int update(@RequestBody CommandeDto dto) {
        Commande commande = converter.map(dto);
        return service.update(commande);
    }

    @GetMapping("ref/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        Commande commande = service.findByRef(ref);
        CommandeDto dto = converter.map(commande);
        return dto;
    }

    @DeleteMapping("ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return service.deleteByRef(ref);
    }
}
