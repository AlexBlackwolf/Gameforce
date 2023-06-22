package com.example.Gamefroce.controllers;

import com.example.Gamefroce.entity.Utente;
import com.example.Gamefroce.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/utente")
public class UtenteController {

    @Autowired
    public UtenteService uService;

    @GetMapping("/insert")
    public ResponseEntity<?> insertUtente(Utente u){
        uService.insertUtente(u);
        return ResponseEntity.ok().build();
    }
}
