package com.example.Gameforce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello extends AuditableEntity{
    private int codiceCarrello;

    @OneToMany(mappedBy = "carrello")
    @JsonManagedReference(value = "ordini-carrello")
    private List<Ordine> ordiniCarrello;

    public Carrello(Long id, int codiceCarrello, String createdOn, String createdBy, String modifiedBy, String modifiedOn) {
        super(id, createdOn, createdBy, modifiedBy, modifiedOn);
        this.codiceCarrello = codiceCarrello;
    }
    public Carrello(){
        super();
    }

    public int getCodiceCarrello() {
        return codiceCarrello;
    }

    public void setCodiceCarrello(int codiceCarrello) {
        this.codiceCarrello = codiceCarrello;
    }
    public List<Ordine> getOrdiniCarrello() {
        return ordiniCarrello;
    }
    public void setOrdiniCarrello(List<Ordine> ordiniCarrello) {
        this.ordiniCarrello = ordiniCarrello;
    }
}

