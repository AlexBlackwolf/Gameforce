package com.example.Gamefroce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Videogioco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVideogioco;
    private String titolo;
    private String genere;
    private String piattaforma;
    private double prezzo;
    private double valutazione;
    private String descrizione;
    private String requisitiDiSistema;

    // Constructors (including default constructor)

    // Getters and Setters

    // Other methods (if any)
}
