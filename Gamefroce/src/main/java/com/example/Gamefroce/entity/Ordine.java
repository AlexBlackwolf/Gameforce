package com.example.Gamefroce.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private Long codiceOrdine;
    private Utente utente;
    private Timestamp dataOrdine;
    private Videogioco videogioco;

    public Ordine(String id,Long codiceOrdine, Utente utente, Timestamp dataOrdine, Videogioco videogioco) {
        this.id = id;
        this.codiceOrdine=codiceOrdine;
        this.utente = utente;
        this.dataOrdine = dataOrdine;
        this.videogioco = videogioco;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCodiceOrdine() {
        return codiceOrdine;
    }

    public void setCodiceOrdine(Long codiceOrdine) {
        this.codiceOrdine = codiceOrdine;
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
