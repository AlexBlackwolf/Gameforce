package com.example.Gameforce.entity;//
// rimosso jakarta per via dei problemi meglio usare javax
import Utils.DataEncryption;
import jakarta.persistence.*;
@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  private Long id;
    private Long codiceUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private String createdBy;
    private String createdOn;
    private String modifiedBy;
    private String modifiedOn;

    public Utente(Long id, Long codiceUtente, String nome, String cognome, String email, String password, String createdBy, String createdOn, String modifiedBy, String modifiedOn) {
        this.id = id;
        this.codiceUtente = codiceUtente;
        this.nome = nome;
        this.cognome = cognome;//email non va criptata
        this.email = email;
        try {     this.password = DataEncryption.encrypt(password);
        }catch(Exception e) {
            e.printStackTrace();
        }
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.modifiedBy = modifiedBy;
        this.modifiedOn = modifiedOn;
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

    public String getModifiedBy() {
        return modifiedBy;
        }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        }

    public String getModifiedOn() {
        return modifiedOn;
        }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
