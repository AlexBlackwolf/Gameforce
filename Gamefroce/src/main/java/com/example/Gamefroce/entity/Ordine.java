package com.example.Gamefroce.entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;


@SpringBootApplication
@EnableJpaRepositories
@Entity
@Table(name = "ordine")
public class Ordine {
    //add
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private int codiceOrdine;
    private Timestamp dataOrdine;

    public Ordine(String id,int codiceOrdine,Timestamp dataOrdine, Videogioco videogioco) {
        this.id = id;
        this.codiceOrdine=codiceOrdine;
        this.dataOrdine = dataOrdine;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
}
