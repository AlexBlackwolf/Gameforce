package com.example.Gameforce.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "ordine")
public class Ordine extends AuditableEntity {

    private int codiceOrdine;
    private Timestamp dataOrdine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonBackReference
    private Utente utente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carello_id", nullable = false)
    @JsonBackReference
    private Carrello carrello;

    @OneToMany(mappedBy = "ordine")
    @JsonManagedReference
    private List<Videogioco> videogiochi;


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
