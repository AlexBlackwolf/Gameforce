package com.example.Gameforce.dto;

import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.entity.Videogioco;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.sql.Timestamp;
import java.util.List;

public class OrdineDTO extends AuditableDTO{

    private int codiceOrdine;
    private Timestamp dataOrdine;
    private UtenteDTO utente;
    private CarrelloDTO carrello;
    private List<VideogiocoDTO> videogiochi;

    public int getCodiceOrdine() {
        return codiceOrdine;
    }

    public void setCodiceOrdine(int codiceOrdine) {
        this.codiceOrdine = codiceOrdine;
    }

    public Timestamp getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Timestamp dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public UtenteDTO getUtente() {
        return utente;
    }

    public void setUtente(UtenteDTO utente) {
        this.utente = utente;
    }

    public CarrelloDTO getCarrello() {
        return carrello;
    }

    public void setCarrello(CarrelloDTO carrello) {
        this.carrello = carrello;
    }

    public List<VideogiocoDTO> getVideogiochi() {
        return videogiochi;
    }

    public void setVideogiochi(List<VideogiocoDTO> videogiochi) {
        this.videogiochi = videogiochi;
    }
}
