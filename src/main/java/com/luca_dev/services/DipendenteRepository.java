package com.luca_dev.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import com.luca_dev.models.Dipendente;

import jakarta.transaction.Transactional;

public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
    @Query(
        " SELECT D.id, D.nome, D.cognome, D.username " +
        " FROM Dipendente as D WHERE D.nome LIKE %:nome% AND D.cognome LIKE %:cognome% "
    )
    List<Object> cercaDipendente(
        @RequestParam String nome,
        @RequestParam String cognome
    );

    @Query(
        " SELECT D.id FROM Dipendente as D " +
        " WHERE D.username = :username AND D.password = :password "
    )
    Long loginDipendente(
        @RequestParam String username,
        @RequestParam String password
    );

    @Modifying
    @Transactional
    @Query(
        "UPDATE Dipendente " +
        "SET nome = :nome, cognome = :cognome, password = :password, username = :username " +
        "WHERE id = :id"
    )
    public void modificaDipendente(
        @RequestParam Long id,
        @RequestParam String nome,
        @RequestParam String cognome,
        @RequestParam String username,
        @RequestParam String password
    );
}
