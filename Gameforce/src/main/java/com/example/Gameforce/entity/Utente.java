package com.example.Gameforce.entity;//
// rimosso jakarta per via dei problemi meglio usare javax
import com.example.Gameforce.utils.DataEncryption;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente extends AuditableEntity {
    private Long codiceUtente;
    private String nome;
    private String cognome;
    @Email(message = "l'email non è valida")
    @NotBlank(message = "questo campo è obbligatorio")
    private String email;

    @NotBlank(message = "questo campo è obbligatorio")
    @Size(min=7 , message = "la password deve contenere almeno 7 caratteri!")
    private String password;
    private Double saldo= 0d;
    private Boolean loginStatus=false; // Considerare l'uso di un enumerato  invece di un booleano

    @OneToMany(mappedBy = "utente")
//    @JsonManagedReference(value = "ordini-utente") non vanno messe se non visualizziamo questi dati nei controller
    private List<Ordine> ordiniUtente;

    @OneToOne
    @JoinColumn(name = "carrello_id")
    private Carrello carrello;

    public Utente(Long id, String createdOn, String createBy, String modifyBy, String modifyOn, Long codiceUtente, String nome, String cognome, String email, String password, List<Ordine> ordiniUtente, Carrello carrello, Double saldo, Boolean loginStatus) {
        super(id, createdOn, createBy, modifyBy, modifyOn);
        this.codiceUtente = codiceUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.ordiniUtente = ordiniUtente;
        this.carrello = carrello;
        this.saldo=saldo;
        this.loginStatus=loginStatus;
    }
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Utente (){
        super();
    }
    public Long getCodiceUtente() {
        return codiceUtente;
    }

    public void setCodiceUtente(Long codiceUtente) {
        this.codiceUtente = codiceUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ordine> getOrdiniUtente() {
        return ordiniUtente;
    }

    public void setOrdiniUtente(List<Ordine> ordiniUtente) {
        this.ordiniUtente = ordiniUtente;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }
}
