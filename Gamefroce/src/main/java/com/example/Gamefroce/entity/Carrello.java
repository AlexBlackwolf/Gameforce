package com.example.Gamefroce.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {
    //finire mapping entity e fare repository
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //chiamare ID
    private String id;
    private Long codiceCarrello;
    private Utente utente;
    //aggiungere 4 colonne aggiuntive created by, created on, modified by, modified on
    //aggiungere cancellazione logica
    //usare WHERE per vedere i record attivi
    private List<Videogioco> videogiochi;
    //aggiungere auditable entity


    public Carrello(String id, Long codiceCarrello, Utente utente, List<Videogioco> videogiochi) {
        this.id = id;
        this.codiceCarrello = codiceCarrello;
        this.utente = utente;
        this.videogiochi = videogiochi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCodiceCarrello() {
        return codiceCarrello;
    }

    public void setCodiceCarrello(Long codiceCarrello) {
        this.codiceCarrello = codiceCarrello;
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

