package com.example.Gamefroce.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long idOrdine;
    private Utente utente;
    private Timestamp dataOrdine;
    private Videogioco videogioco;

    public Ordine(Long idOrdine, Utente utente, Timestamp dataOrdine, Videogioco videogioco) {
        this.idOrdine = idOrdine;
        this.utente = utente;
        this.dataOrdine = dataOrdine;
        this.videogioco = videogioco;
    }

    public Long getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(Long idOrdine) {
        this.idOrdine = idOrdine;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Timestamp getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Timestamp dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public Videogioco getVideogioco() {
        return videogioco;
    }

    public void setVideogioco(Videogioco videogioco) {
        this.videogioco = videogioco;
    }
}
