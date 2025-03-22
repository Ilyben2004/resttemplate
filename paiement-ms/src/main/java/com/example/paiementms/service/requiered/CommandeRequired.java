package com.example.paiementms.service.requiered;

import com.example.paiementms.ws.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandeRequired {

    private String baseUrl = "http://localhost:8080/api/admin/";
    private String url = baseUrl + "commande/";
    @Autowired
    private RestTemplate restTemplate;

    public CommandeDto findByRef(String ref) {
        CommandeDto commandeDto = restTemplate.getForEntity(url+"ref/"+ref, CommandeDto.class).getBody();
        return commandeDto;
    }

    public int update(CommandeDto commandeDto) {
        int result = restTemplate.postForObject(url, commandeDto, Integer.class);
        return result;
    }
}
