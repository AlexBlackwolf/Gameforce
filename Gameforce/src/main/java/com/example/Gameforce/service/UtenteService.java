package com.example.Gameforce.service;

import com.example.Gameforce.dto.LoginDTO;
import com.example.Gameforce.dto.UtenteDTO;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.repository.OrdineRepo;
import com.example.Gameforce.repository.UtenteRepo;
import com.example.Gameforce.utils.DataEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService{
    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private OrdineRepo ordineRepo;
    public Utente registerUtente(@Valid Utente utente){
        if(utenteRepo.findByEmail(utente.getEmail()) != null){
            throw new RuntimeException("L'email è già registrata");
        }
        this.encryptPassword(utente.getPassword());
        return utenteRepo.save(utente);
    }

    private void encryptPassword(String password) {
        try {
            if(password ==null){
            }
            else{
                DataEncryption.encrypt(password);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Utente login(LoginDTO loginDTO) {
        Optional<Utente> userToLogin = Optional.ofNullable(utenteRepo.findByEmail(loginDTO.getEmail()));

        if (userToLogin.isEmpty()){

            throw new RuntimeException("email o password errata!");
        }
        if (userToLogin.get().getPassword().equals(loginDTO.getPassword())) {
            userToLogin.get().setLoginStatus(true);
            return utenteRepo.save(userToLogin.get());
        }
        else
            throw new RuntimeException("email o password errata!");
    }
    public Utente logout(Long id){
        Optional<Utente> userToLogout = utenteRepo.findById(id);
        userToLogout.get().setLoginStatus(false);
        return utenteRepo.save(userToLogout.get());
    }

    public void addUtente(UtenteDTO utente){
         Utente u = new Utente();
         u.setCodiceUtente(utente.getCodiceUtente());
         u.setNome(utente.getNome());
         u.setCognome(utente.getCognome());
         u.setEmail(utente.getEmail());
         utenteRepo.save(u);
    }

    public UtenteDTO getUtenteById(Long id){
        Optional<Utente> utente = utenteRepo.findById(id);
        if (utente.isPresent()){
            UtenteDTO uDto = new UtenteDTO();
            Utente u = utente.get();
            uDto.setId(u.getId());
            uDto.setCodiceUtente(u.getCodiceUtente());
            uDto.setNome(u.getNome());
            uDto.setCognome(u.getCognome());
            uDto.setEmail(u.getEmail());

            return uDto;
        }

        return null;
    }
    public List<UtenteDTO> getUtenti(){
        List<Utente> utenti = utenteRepo.findAll();
        List<UtenteDTO> utentiDTO = new ArrayList<>();

        for (Utente u : utenti){
            UtenteDTO uDto = new UtenteDTO();
            if (!utenti.isEmpty()){
                uDto.setId(u.getId());
                uDto.setCodiceUtente(u.getCodiceUtente());
                uDto.setNome(u.getNome());
                uDto.setCognome(u.getCognome());
                uDto.setEmail(u.getEmail());
                utentiDTO.add(uDto);
            }
        }
        return utentiDTO;
    }

    public void deleteUtenteById(Long id){
        utenteRepo.deleteById(id);
    }

    public Utente updateUtente(UtenteDTO utente){
        if (utente.getId()==null){
            throw new RuntimeException("Utente non trovato");
        }
        Utente u = new Utente();
        u.setId(utente.getId());
        u.setCodiceUtente(utente.getCodiceUtente());
        u.setNome(utente.getNome());
        u.setCognome(utente.getCognome());
        u.setEmail(utente.getEmail());
        return utenteRepo.save(u);
    }

    public void logicalDelete(Long id){
        Optional<Utente> optionalEntity = utenteRepo.findById(id);
        optionalEntity.ifPresent(entity->{entity.setDeleted(true);
            utenteRepo.save(entity);});

    }

    public void aggiungiSaldo(Long id, double saldo) throws Exception {
        Optional<Utente> optionalUtente = utenteRepo.findById(id);
        if (optionalUtente.isPresent()) {
            Utente utente = optionalUtente.get();
            double newSaldo = utente.getSaldo() + saldo;
            utente.setSaldo(newSaldo);
            utenteRepo.save(utente);
        } else {
            throw new Exception("Utente not found with ID: " + id);
        }
    }
}
