package com.example.Gameforce.dto;

public class VideogiocoDTO extends AuditableDTO{
    private Integer codiceVideogioco;
    private String titolo;

    private Double prezzo;
    private Double valutazione;
    private String descrizione;
    private String requisitiDiSistema;
    private OrdineDTO ordine;

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

}
