package com.example.Gameforce.entity;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "ordine")
public class Ordine extends AuditableEntity {

    private int codiceOrdine;
    private Timestamp dataOrdine;

    // deletedBy and deletedOn are not present in the constructor as they are null by default, when the entity is created, and will be modified once it has been deleted.

    public Ordine(Long id, int codiceOrdine, Timestamp dataOrdine, String createdBy, String createdOn, String modifiedOn, String modifiedby) {
        super(id, createdOn, createdBy, modifiedby, modifiedOn);
        this.codiceOrdine = codiceOrdine;
        this.dataOrdine = dataOrdine;
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
