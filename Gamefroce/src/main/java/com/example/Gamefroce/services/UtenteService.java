package com.example.Gamefroce.services;

import com.example.Gamefroce.entity.Utente;
import com.example.Gamefroce.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    public UtenteRepo uRepo;

    public void insertUtente (Utente u){
        uRepo.save(u);
    }
}
