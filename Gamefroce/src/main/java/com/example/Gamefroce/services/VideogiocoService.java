package com.example.Gamefroce.services;

import com.example.Gamefroce.repository.VideogiocoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideogiocoService {

    @Autowired
    public VideogiocoRepo vRepo;
}
