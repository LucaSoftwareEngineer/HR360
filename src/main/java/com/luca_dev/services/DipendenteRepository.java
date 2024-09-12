package com.luca_dev.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca_dev.models.Dipendente;

public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {
    
}
