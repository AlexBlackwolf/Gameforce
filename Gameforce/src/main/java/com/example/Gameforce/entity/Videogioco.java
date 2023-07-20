package com.example.Gameforce.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "videogioco")
public class Videogioco extends AuditableEntity{

    private Integer codiceVideogioco;
    private String titolo;
    private Double prezzo;
    private Double valutazione;
    private String descrizione;
    private String requisitiDiSistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id")
    @JsonBackReference(value = "ordini-videogioco")
    private Ordine ordine;

    public Videogioco(Long id, String createdOn, String createBy, String modifyBy, String modifyOn, Integer codiceVideogioco, String titolo, Double prezzo, Double valutazione, String descrizione, String requisitiDiSistema, Ordine ordine) {
        super(id, createdOn, createBy, modifyBy, modifyOn);
        this.codiceVideogioco = codiceVideogioco;
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.valutazione = valutazione;
        this.descrizione = descrizione;
        this.requisitiDiSistema = requisitiDiSistema;
        this.ordine = ordine;
    }

    public Videogioco (){
        super();
    }

    public Integer getCodiceVideogioco() {
        return codiceVideogioco;
    }

    public void setCodiceVideogioco(Integer codiceVideogioco) {
        this.codiceVideogioco = codiceVideogioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Double getValutazione() {
        return valutazione;
    }

    public void setValutazione(Double valutazione) {
        this.valutazione = valutazione;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getRequisitiDiSistema() {
        return requisitiDiSistema;
    }

    public void setRequisitiDiSistema(String requisitiDiSistema) {
        this.requisitiDiSistema = requisitiDiSistema;
    }

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
}
