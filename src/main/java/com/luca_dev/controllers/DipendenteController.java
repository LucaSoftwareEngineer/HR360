package com.luca_dev.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.luca_dev.models.Dipendente;
import com.luca_dev.services.DipendenteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


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

    @PutMapping("/dipendente/modifica")
    public Object modificaDipendente(
        @RequestParam("id") Long id,
        @RequestParam("nome") String nome,
        @RequestParam("cognome") String cognome,
        @RequestParam("username") String username,
        @RequestParam("password") String password
    ) {
        if (id>0) {
            dipendenteRepositoryInstance.modificaDipendente(id, nome, cognome, username, password);
        }
        return "OK";
    }
    
    
    @GetMapping("/dipendente/cerca")
    public List<Object> cercaDipendente(
        @RequestParam("nome") String nome,
        @RequestParam("cognome") String cognome
    ) {
        return dipendenteRepositoryInstance.cercaDipendente(nome, cognome);
    }

    @GetMapping("/dipendente/login")
    public Long loginDipendente(
        @RequestParam("username") String username,
        @RequestParam("password") String password
    ) {
        Long id = dipendenteRepositoryInstance.loginDipendente(username, password);
        if (id == null) {
            id = 0L;
        }
        return id;
    }
    
    
}
