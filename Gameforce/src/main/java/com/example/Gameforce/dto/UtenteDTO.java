package com.example.Gameforce.dto;

import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.entity.Ordine;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class UtenteDTO extends AuditableDTO{

    private Long codiceUtente;
    private String nome;
    private String cognome;
    private String email;
    private List<OrdineDTO> ordiniUtente;
    private CarrelloDTO carrello;

    public Long getCodiceUtente() {
        return codiceUtente;
    }

    public void setCodiceUtente(Long codiceUtente) {
        this.codiceUtente = codiceUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OrdineDTO> getOrdiniUtente() {
        return ordiniUtente;
    }

    public void setOrdiniUtente(List<OrdineDTO> ordiniUtente) {
        this.ordiniUtente = ordiniUtente;
    }

    public CarrelloDTO getCarrello() {
        return carrello;
    }

    public void setCarrello(CarrelloDTO carrello) {
        this.carrello = carrello;
    }
}
