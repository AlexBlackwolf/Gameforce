package com.example.Gameforce.dto;

import com.example.Gameforce.entity.Ordine;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class CarrelloDTO extends AuditableDTO{
    private int codiceCarrello;

    private List<Ordine> ordiniCarello;

    public int getCodiceCarrello() {
        return codiceCarrello;
    }

    public void setCodiceCarrello(int codiceCarrello) {
        this.codiceCarrello = codiceCarrello;
    }

    public List<Ordine> getOrdiniCarello() {
        return ordiniCarello;
    }

    public void setOrdiniCarello(List<Ordine> ordiniCarello) {
        this.ordiniCarello = ordiniCarello;
    }
}
