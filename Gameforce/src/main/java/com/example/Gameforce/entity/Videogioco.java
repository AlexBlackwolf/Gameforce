package com.example.Gameforce.entity;
import com.example.Gameforce.Enum.PiattaformaEnum;
import com.example.Gameforce.Enum.VideogiocoEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "videogioco")
public class Videogioco extends AuditableEntity{
    //cancellato annotation ID dato che l'id sarà preso dalla classe padre

    //modifiy to auto-incre, int
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer codiceVideogioco;
    private String titolo;


    private List<PiattaformaEnum> piattaforma = new ArrayList<>();
    private Double prezzo;
    private Double valutazione;
    private String descrizione;
    private String requisitiDiSistema;
    private List<VideogiocoEnum> generi = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordine_id")
    @JsonBackReference(value = "ordini-videogioco")
    private Ordine ordine;

    // Constructors (including default constructor)

    // Getters and Setters

    // Other methods (if any)

    // fill constructor

    // add


    public Videogioco(Long id, String createdOn, String createBy, String modifyBy, String modifyOn, int codiceVideogioco, String titolo, List<VideogiocoEnum>generi, List<PiattaformaEnum> piattaforma, double prezzo, double valutazione, String descrizione, String requisitiDiSistema, Ordine ordine) {
        super(id, createdOn, createBy, modifyBy, modifyOn);
        this.codiceVideogioco = codiceVideogioco;
        this.titolo = titolo;
        this.generi = generi;
        this.piattaforma = piattaforma;
        this.prezzo = prezzo;
        this.valutazione = valutazione;
        this.descrizione = descrizione;
        this.requisitiDiSistema = requisitiDiSistema;
        this.ordine = ordine;
    }

    public Videogioco (){
        super();
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

    public List<VideogiocoEnum> getGeneri() {
        return generi;
    }

    public void removeGeneri(VideogiocoEnum videogiocoEnumRemover){generi.remove(videogiocoEnumRemover);
    }

    public void addGeneri(VideogiocoEnum videogiocoEnumAdder){generi.add(videogiocoEnumAdder);
    }
    public void addPiattaforma (PiattaformaEnum piattaformaEnumAdder){piattaforma.add(piattaformaEnumAdder);}
    public List<PiattaformaEnum> getPiattaforma() {
        return piattaforma;
    }

    public void setPiattaforma(List<PiattaformaEnum> piattaforma) {
        this.piattaforma = piattaforma;
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
