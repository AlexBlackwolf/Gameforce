package com.example.Gameforce.entity;//
// rimosso jakarta per via dei problemi meglio usare javax
import com.example.Gameforce.utils.DataEncryption;
import jakarta.persistence.*;
@Entity
@Table(name = "utente")
public class Utente extends AuditableEntity {

    private Long codiceUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    public Utente(Long id, Long codiceUtente, String nome, String cognome, String email, String password, String createdBy, String createdOn, String modifiedBy, String modifiedOn) {
        super(id, createdOn, createdBy, modifiedBy, modifiedOn);
        this.codiceUtente = codiceUtente;
        this.nome = nome;
        this.cognome = cognome;//email non va criptata
        this.email = email;
        try {
            this.password = DataEncryption.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
