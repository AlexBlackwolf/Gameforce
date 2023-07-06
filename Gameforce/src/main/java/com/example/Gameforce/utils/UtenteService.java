package com.example.Gameforce.utils;

import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService extends EntityTrackingService {
    @Autowired
    private UtenteRepo utenteRepo;

    public void addUtente(Utente utente){
       utenteRepo.save(utente);
    }
    public List<Utente> getUtente(){
        return utenteRepo.findAll();
    }
    public void deleteUtente(Utente utente){
        utenteRepo.delete(utente);
    }
    public void deleteUtenteById(Long id){
        utenteRepo.deleteById(id);
    }
    public void updateUtente(Long id,Utente utente){
        utenteRepo.deleteById(id);
        utenteRepo.save(utente);
    }


}
