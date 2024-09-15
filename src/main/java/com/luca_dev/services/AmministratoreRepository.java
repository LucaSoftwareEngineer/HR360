package com.luca_dev.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luca_dev.models.Amministratore;

public interface AmministratoreRepository extends JpaRepository<Long, Amministratore> {
    
}