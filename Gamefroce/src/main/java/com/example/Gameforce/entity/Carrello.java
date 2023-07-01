package com.example.Gameforce.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carrello")
public class Carrello extends AuditableEntity{
    //finire mapping entity e fare repository
    //chiamare ID
    private int codiceCarrello;

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
}

