package com.example.Gamefroce.controllers;

import com.example.Gamefroce.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/utente")
public class UtenteController {

    @Autowired
    public UtenteService uService;
}
