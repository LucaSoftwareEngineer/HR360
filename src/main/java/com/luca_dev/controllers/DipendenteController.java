package com.luca_dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RestController;

import com.luca_dev.models.Dipendente;
import com.luca_dev.services.DipendenteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class DipendenteController {

    @Autowired
    DipendenteRepository dipendenteRepositoryInstance;

    @PostMapping("/dipendente/aggiungi")
    public Dipendente aggiungiDipendente(
        @RequestParam("nome") String nome,
        @RequestParam("cognome") String cognome,
        @RequestParam("username") String username,
        @RequestParam("password") String password
    ) {
        Dipendente dipendente = new Dipendente(nome, cognome, username, password);
        return dipendenteRepositoryInstance.save(dipendente);
    }
    
    
}
