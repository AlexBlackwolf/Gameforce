package com.example.Gamefroce.entity;
import Utils.DataEncryption;

//rimosso jakarta per via dei problemi meglio usare javax

import jakarta.persistence.*;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long codiceUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String createdBy;
    private String createdOn;
    private String modifyBy;
    private String modifyOn;

    //rimosso throw dato che il costruttore non lo deve contenere


    public Utente(Long id, Long codiceUtente, String nome, String cognome, String email, String password, String createdBy, String createdOn, String modifyBy, String modifyOn) {
        this.id = id;
        this.codiceUtente = codiceUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        try {
                this.password = DataEncryption.encrypt(password);
            }catch(Exception e) {
                e.printStackTrace();
            }
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifyBy = modifyBy;
        this.modifyOn = modifyOn;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    //aggiunto encrypt della password in caso di set
    public void setPassword(String password) {
        try {
            this.password = DataEncryption.encrypt(password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyOn() {
        return modifyOn;
    }

    public void setModifyOn(String modifyOn) {
        this.modifyOn = modifyOn;
    }
}
