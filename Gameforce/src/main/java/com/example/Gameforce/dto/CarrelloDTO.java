package com.example.Gameforce.dto;

import com.example.Gameforce.entity.Ordine;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

public class CarrelloDTO extends AuditableDTO{
    private Integer codiceCarrello;

    private List<OrdineDTO> ordiniCarello;

    public Integer getCodiceCarrello() {
        return codiceCarrello;
    }

    public void setCodiceCarrello(Integer codiceCarrello) {
        this.codiceCarrello = codiceCarrello;
    }

    public List<OrdineDTO> getOrdiniCarello() {
        return ordiniCarello;
    }

    public void setOrdiniCarello(List<OrdineDTO> ordiniCarello) {
        this.ordiniCarello = ordiniCarello;
    }
}
