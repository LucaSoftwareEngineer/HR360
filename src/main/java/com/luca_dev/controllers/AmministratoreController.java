package com.luca_dev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.luca_dev.services.AmministratoreRepository;

@RestController
public class AmministratoreController {

    @Autowired
    AmministratoreRepository amministratoreRepository;

    
}
