package com.example.paiementms.ws.facade;

import com.example.paiementms.entity.Paiement;
import com.example.paiementms.service.facade.PaiementService;
import com.example.paiementms.ws.converter.PaiementConverter;
import com.example.paiementms.ws.dto.PaiementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/admin/paiement/")
public class PaiementWs {

    @Autowired
    private PaiementConverter converter;

    @Autowired
    private PaiementService service;

    @PostMapping
    public int save(@RequestBody PaiementDto dto) {
        Paiement entity = converter.map(dto);
        return service.save(entity);
    }

    @DeleteMapping("code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }

    @GetMapping("code/{code}")
    public PaiementDto findByCode(@PathVariable String code) {
        Paiement paiement = service.findByCode(code);
        PaiementDto dto = converter.map(paiement);
        return dto;
    }

    @GetMapping()
    public List<PaiementDto> findAll() {
        List<Paiement> paiements = service.findAll();
        List<PaiementDto> list = paiements.stream().map(e -> converter.map(e)).collect(Collectors.toList());
        return list;
    }
}
