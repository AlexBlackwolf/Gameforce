package com.example.Gamefroce.entity;
import Utils.DataEncryption;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//rimosso jakarta per via dei problemi meglio usare javax



@SpringBootApplication
@EnableJpaRepositories
@Entity
@Table(name = "utente")
public class Utente {
    //add
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private int codiceUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    //rimosso throw dato che il costruttore non lo deve contenere
    public Utente(String id,int codiceUtente, String nome, String cognome, String email, String password)  {
        this.id=id;
        this.codiceUtente=codiceUtente;
        this.nome = nome;
        this.cognome = cognome;
        //email non va criptata
        this.email = email;
        try {
            this.password = DataEncryption.encrypt(password);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCodiceUtente() {
        return codiceUtente;
    }

    public void setCodiceUtente(int codiceUtente) {
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
}
