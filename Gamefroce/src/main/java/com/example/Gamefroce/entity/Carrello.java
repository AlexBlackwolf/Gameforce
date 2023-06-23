package com.example.Gamefroce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarrello;
    private Utente utente;
    private List<Videogioco> videogiochi;

    public Carrello(Utente utente, List<Videogioco> videogiochi) {
        this.utente = utente;
        this.videogiochi = videogiochi;
    }

    public Long getIdCarrello() {
        return idCarrello;
    }

    public void setIdCarrello(Long idCarrello) {
        this.idCarrello = idCarrello;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<Videogioco> getVideogiochi() {
        return videogiochi;
    }

    public void setVideogiochi(List<Videogioco> videogiochi) {
        this.videogiochi = videogiochi;
    }
}

