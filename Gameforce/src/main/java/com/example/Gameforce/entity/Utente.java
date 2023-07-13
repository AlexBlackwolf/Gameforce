package com.example.Gameforce.entity;//
// rimosso jakarta per via dei problemi meglio usare javax
import com.example.Gameforce.utils.DataEncryption;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.aspectj.weaver.ast.Or;

import java.util.List;

@Entity
@Table(name = "utente")
public class Utente extends AuditableEntity {
    private Long codiceUtente;
    private String nome;
    private String cognome;
    private String email;
    private String password;

    @OneToMany(mappedBy = "utente")
    @JsonManagedReference(value = "ordini-utente")
    private List<Ordine> ordiniUtente;

    @OneToOne
    @JoinColumn(name = "carrello_id")
    private Carrello carrello;

    public Utente(Long id, String createdOn, String createBy, String modifyBy, String modifyOn, Long codiceUtente, String nome, String cognome, String email, String password, List<Ordine> ordiniUtente, Carrello carrello) {
        super(id, createdOn, createBy, modifyBy, modifyOn);
        this.codiceUtente = codiceUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.ordiniUtente = ordiniUtente;
        this.carrello = carrello;
    }

    //    public Utente(Long id, Long codiceUtente, String nome, String cognome, String email, String password, String createdBy, String createdOn, String modifiedBy, String modifiedOn) {
//        super(id, createdOn, createdBy, modifiedBy, modifiedOn);
//        this.codiceUtente = codiceUtente;
//        this.nome = nome;
//        this.cognome = cognome;//email non va criptata
//        this.email = email;
//        this.password=password;
//    }
    public Utente (){
        super();
    }
    // check if password is not null and if exist encrypt the password
    //gli oggetti vengono creati nel database quando passano dal service
    //Entity mapping
    //muoverla nel service
    private void extracted(String password) {
        try {
            if(password ==null){
                }
            else{
            this.password = DataEncryption.encrypt(password);
            }

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
    // refactoring
    public void setPassword(String password) {
        try {
            this.password = DataEncryption.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
