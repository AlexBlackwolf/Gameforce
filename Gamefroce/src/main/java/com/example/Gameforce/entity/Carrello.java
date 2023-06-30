package com.example.Gameforce.entity;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Entity
@Table(name = "carrello")
public class Carrello {
    //finire mapping entity e fare repository
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //chiamare ID
    private String id;
    private int codiceCarrello;
    private String createdOn;
    private String createBy;
    private String modifyBy;
    private String modifyOn;


    //aggiungere 4 colonne aggiuntive created by, created on, modified by, modified on
    //aggiungere cancellazione logica
    //usare WHERE per vedere i record attivi
    //aggiungere auditable entity
    //add
    public Carrello(String id, int codiceCarrello, String createdOn, String createBy, String modifyBy, String modifyOn) {
        this.id = id;
        this.codiceCarrello = codiceCarrello;
        this.createdOn = createdOn;
        this.createBy = createBy;
        this.modifyBy = modifyBy;
        this.modifyOn = modifyOn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCodiceCarrello() {
        return codiceCarrello;
    }

    public void setCodiceCarrello(int codiceCarrello) {
        this.codiceCarrello = codiceCarrello;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(String modifyOn) {
        this.modifyOn = modifyOn;
    }
}

