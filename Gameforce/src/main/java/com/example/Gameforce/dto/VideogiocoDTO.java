package com.example.Gameforce.dto;

import com.example.Gameforce.Enum.PiattaformaEnum;
import com.example.Gameforce.Enum.VideogiocoEnum;
import com.example.Gameforce.entity.Ordine;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.ArrayList;
import java.util.List;

public class VideogiocoDTO extends AuditableDTO{
    private Integer codiceVideogioco;
    private String titolo;
    private List<VideogiocoEnum> generi = new ArrayList<>();
    private List<PiattaformaEnum> piattaforma = new ArrayList<>();
    private Double prezzo;
    private Double valutazione;
    private String descrizione;
    private String requisitiDiSistema;
    private OrdineDTO ordine;

    public int getCodiceVideogioco() {
        return codiceVideogioco;
    }

    public void setCodiceVideogioco(int codiceVideogioco) {
        this.codiceVideogioco = codiceVideogioco;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public List<VideogiocoEnum> getGeneri() {
        return generi;
    }

    public void setGeneri(List<VideogiocoEnum> generi) {
        this.generi = generi;
    }

    public List<PiattaformaEnum> getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(List<PiattaformaEnum> piattaforma) {
        this.piattaforma = piattaforma;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public double getValutazione() {
        return valutazione;
    }

    public void setValutazione(double valutazione) {
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

     public OrdineDTO getOrdine() {
     return ordine;
     }

     public void setOrdine(OrdineDTO ordine) {
     this.ordine = ordine;
   }
}
