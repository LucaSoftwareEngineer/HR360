package com.luca_dev.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class IndexController {
    
    @GetMapping("/")
    public String appStart() {
        return "HR360 START OK";
    }
    

}
