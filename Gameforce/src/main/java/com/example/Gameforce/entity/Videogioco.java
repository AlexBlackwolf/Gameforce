package com.example.Gameforce.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "videogioco")
public class Videogioco extends AuditableEntity{
    //cancellato annotation ID dato che l'id sarà preso dalla classe padre

    //modifiy to auto-incre, int
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codiceVideogioco;
    private String titolo;
    private String genere;
    private String piattaforma;
    private double prezzo;
    private double valutazione;
    private String descrizione;
    private String requisitiDiSistema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id", nullable = false)
//    @JsonBackReference(value = "ordini-videogioco")
    private Ordine ordine;

    // Constructors (including default constructor)

    // Getters and Setters

    // Other methods (if any)

    // fill constructor

    // add


    public Videogioco(Long id, String createdOn, String createBy, String modifyBy, String modifyOn, int codiceVideogioco, String titolo, String genere, String piattaforma, double prezzo, double valutazione, String descrizione, String requisitiDiSistema, Ordine ordine) {
        super(id, createdOn, createBy, modifyBy, modifyOn);
        this.codiceVideogioco = codiceVideogioco;
        this.titolo = titolo;
        this.genere = genere;
        this.piattaforma = piattaforma;
        this.prezzo = prezzo;
        this.valutazione = valutazione;
        this.descrizione = descrizione;
        this.requisitiDiSistema = requisitiDiSistema;
        this.ordine = ordine;
    }

    //    public Videogioco(Long id, String createdOn, String createdBy, String modifiedBy, String modifiedOn, int codiceVideogioco, String titolo, String genere, String piattaforma, double prezzo, double valutazione, String descrizione, String requisitiDiSistema,  String deletedBy, String deletedOn) {
//        super(id, createdOn, createdBy, modifiedBy, modifiedOn);
//        this.codiceVideogioco = codiceVideogioco;
//        this.titolo = titolo;
//        this.genere = genere;
//        this.piattaforma = piattaforma;
//        this.prezzo = prezzo;
//        this.valutazione = valutazione;
//        this.descrizione = descrizione;
//        this.requisitiDiSistema = requisitiDiSistema;
//    }
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

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(String piattaforma) {
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

    public Ordine getOrdine() {
        return ordine;
    }

    public void setOrdine(Ordine ordine) {
        this.ordine = ordine;
    }
}
