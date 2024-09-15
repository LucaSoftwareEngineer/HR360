package com.luca_dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.luca_dev.models.Amministratore;
import com.luca_dev.services.AmministratoreRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AmministratoreController {

    @Autowired
    AmministratoreRepository amministratoreRepositoryIstance;

    @PostMapping("/amministratore/aggiungi")
    public Amministratore amministratoreAggiungi(
        @RequestParam("nome") String nome,
        @RequestParam("cognome") String cognome,
        @RequestParam("username") String username,
        @RequestParam("password") String password
    ) {
        Amministratore amministratore = new Amministratore(nome, cognome, username, password);
        return amministratoreRepositoryIstance.save(amministratore);
    }
    
}
