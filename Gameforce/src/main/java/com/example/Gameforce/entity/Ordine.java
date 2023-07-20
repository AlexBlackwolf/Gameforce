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
    @JoinColumn(name = "utente_id")
    @JsonBackReference(value = "ordini-utente")
    private Utente utente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carello_id")
    @JsonBackReference(value = "ordini-carrello")
    private Carrello carrello;

    @OneToMany(mappedBy = "ordine",fetch = FetchType.LAZY)
    @JsonManagedReference(value = "ordini-videogioco")
    private List<Videogioco> videogiochi;

    public Ordine (){
        super();
    }

    public Ordine(int codiceOrdine, Timestamp dataOrdine, Utente utente, Carrello carrello, List<Videogioco> videogiochi) {
        super ();
        this.codiceOrdine = codiceOrdine;
        this.dataOrdine = dataOrdine;
        this.utente = utente;
        this.carrello = carrello;
        this.videogiochi = videogiochi;
    }


    // deletedBy and deletedOn are not present in the constructor as they are null by default, when the entity is created, and will be modified once it has been deleted.


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

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public List<Videogioco> getVideogiochi() {
        return videogiochi;
    }

    public void setVideogiochi(List<Videogioco> videogiochi) {
        this.videogiochi = videogiochi;
    }

    public List<Videogioco> addVideogioco(Videogioco videogioco){
        videogiochi.add(videogioco);
        return videogiochi;
    }
}
