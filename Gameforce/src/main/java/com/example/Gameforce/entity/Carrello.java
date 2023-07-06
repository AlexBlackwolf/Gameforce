package com.example.Gameforce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello extends AuditableEntity{
    //finire mapping entity e fare repository
    //chiamare ID
    private int codiceCarrello;



    @OneToMany(mappedBy = "carrello")
    @JsonManagedReference
    private List<Ordine> ordiniCarello;

    //aggiungere 4 colonne aggiuntive created by, created on, modified by, modified on
    //aggiungere cancellazione logica
    //usare WHERE per vedere i record attivi
    //aggiungere auditable entity
    //add
    public Carrello(Long id, int codiceCarrello, String createdOn, String createdBy, String modifiedBy, String modifiedOn) {
        super(id, createdOn, createdBy, modifiedBy, modifiedOn);
        this.codiceCarrello = codiceCarrello;
    }

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

