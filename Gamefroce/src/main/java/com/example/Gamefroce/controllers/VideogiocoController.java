package com.example.Gamefroce.controllers;

import com.example.Gamefroce.services.VideogiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/videogioco")
public class VideogiocoController {

    @Autowired
    public VideogiocoService vService;
}
