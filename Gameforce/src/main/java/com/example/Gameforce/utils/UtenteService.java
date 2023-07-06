package com.example.Gameforce.utils;

import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.repository.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService{
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
    public void logicalDelete(Long id){
        Optional<Utente> optionalEntity = utenteRepo.findById(id);
        optionalEntity.ifPresent(entity->{entity.setDeleted(true);
            utenteRepo.save(entity);});
    }


}
