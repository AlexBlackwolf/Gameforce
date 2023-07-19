package com.example.Gameforce.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello extends AuditableEntity{
    private Integer codiceCarrello;

    @OneToMany(mappedBy = "carrello")
    @JsonManagedReference(value = "ordini-carrello")
    private List<Ordine> ordiniCarello;

    public Carrello(Long id, Integer codiceCarrello, String createdOn, String createdBy, String modifiedBy, String modifiedOn) {
        super(id, createdOn, createdBy, modifiedBy, modifiedOn);
        this.codiceCarrello = codiceCarrello;
    }
    public Carrello(){
        super();
    }

    public Integer getCodiceCarrello() {
        return codiceCarrello;
    }

    public void setCodiceCarrello(Integer codiceCarrello) {
        this.codiceCarrello = codiceCarrello;
    }
    public List<Ordine> getOrdiniCarello() {
        return ordiniCarello;
    }
    public void setOrdiniCarello(List<Ordine> ordiniCarello) {
        this.ordiniCarello = ordiniCarello;
    }
    public List<Ordine> addOrdineIntoCarrello(Ordine ordine){
     ordiniCarello.add(ordine);
     return ordiniCarello;
    }
    public void svuotaCarrello(){
        ordiniCarello.forEach(ordine -> ordiniCarello.remove(ordine));
    }
    public Double acquistaCarrello(){
        Double costoCarrello= 0d;
        for (int i = 0; i < ordiniCarello.size() ; i++) {
            List<Videogioco> videogioco= ordiniCarello.get(i).getVideogiochi();
            costoCarrello=videogioco.get(i).getPrezzo()+costoCarrello;
        }
        this.svuotaCarrello();
        return costoCarrello;


    }

}

