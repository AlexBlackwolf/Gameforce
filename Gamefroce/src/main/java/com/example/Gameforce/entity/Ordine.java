package com.example.Gameforce.entity;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.sql.Timestamp;

@Entity
@Table(name = "ordine")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;
    private int codiceOrdine;
    private Timestamp dataOrdine;
    private String createdBy;
    private String createdOn;
    private String deletedBy;
    private String deletedOn;


    // deletedBy and deletedOn are not present in the constructor as they are null by default, when the entity is created, and will be modified once it has been deleted.

    public Ordine(String id, int codiceOrdine, Timestamp dataOrdine, String createdBy, String createdOn) {
        this.id = id;
        this.codiceOrdine = codiceOrdine;
        this.dataOrdine = dataOrdine;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
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

    public String getCreatedBy() {
        return createdBy;
    }


    public String getCreatedOn() {
        return createdOn;
    }


    public String getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(String deletedBy) {
        this.deletedBy = deletedBy;
    }

    public String getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(String deletedOn) {
        this.deletedOn = deletedOn;
    }
}
