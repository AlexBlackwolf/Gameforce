package com.example.Gamefroce.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;



@Entity
@Table(name = "carrello")
public class Carrello {
    //finire mapping entity e fare repository
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //chiamare ID
    private String id;
    private int codiceCarrello;
    //aggiungere 4 colonne aggiuntive created by, created on, modified by, modified on
    //aggiungere cancellazione logica
    //usare WHERE per vedere i record attivi
    //aggiungere auditable entity
    //add
    public Carrello(String id, int codiceCarrello) {
        this.id = id;
        this.codiceCarrello = codiceCarrello;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCodiceCarrello() {
        return codiceCarrello;
    }

    public void setCodiceCarrello(int codiceCarrello) {
        this.codiceCarrello = codiceCarrello;
    }

    }

