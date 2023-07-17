package com.example.Gameforce.service;

import com.example.Gameforce.dto.LoginDTO;
import com.example.Gameforce.dto.OrdineDTO;
import com.example.Gameforce.dto.UtenteDTO;
import com.example.Gameforce.entity.Ordine;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.repository.OrdineRepo;
import com.example.Gameforce.repository.UtenteRepo;
import com.example.Gameforce.utils.DataEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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


    //gestire gli optional
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

    //Trasformare il risultato in una ResponseEntity, così da non usare le throw e i runtime
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


    public void addUtente(Utente utente){
       utenteRepo.save(utente);
    }

    public void addUtenteDto(UtenteDTO utente){
         Utente u = new Utente();
         u.setCodiceUtente(utente.getCodiceUtente());
         u.setNome(utente.getNome());
         u.setCognome(utente.getCognome());
         u.setEmail(utente.getEmail());
        utenteRepo.save(u);
    }

    public Optional<Utente> getUtenteById(Long id){
        return utenteRepo.findById(id);
    }

    // ho aggiunto il metodo findById con il dto.
    public UtenteDTO getUtenteDto(Long id){
        Optional<Utente> utente = utenteRepo.findById(id);
        if (utente.isPresent()){
            UtenteDTO uDto = new UtenteDTO();
            Utente u = utente.get();
            uDto.setId(u.getId());
            uDto.setCodiceUtente(u.getCodiceUtente());
            uDto.setNome(u.getNome());
            uDto.setCognome(u.getCognome());
            uDto.setEmail(u.getEmail());
//            List<Ordine> ordini = ordineRepo.findAll();
//
//            List<OrdineDTO> ordineMatches = new ArrayList<>();
//            for (Ordine o : ordini){
//                if(o.getUtente().getId().equals(uDto.getId())){
//                    OrdineDTO match = new OrdineDTO();
//                    match.setId(o.getId());
//                    match.setCodiceOrdine(o.getCodiceOrdine());
//                    //match.setVideogiochi(o.getVideogiochi()); probabilmente questa non funzionerà al momento ma la lascio per sistemarla in seguito. bisogna inserire un altro ciclo for per riempirlo.
//
//                    ordineMatches.add(match);
//                }
//            }
//            //manca il carrello. lo aggiungo in seguito se vogliamo far visualizzare anche quello al front end
//
//            uDto.setOrdiniUtente(ordineMatches);

            return uDto;
        }

        return null;// per far tornare il 404 abbiamo creato il metodo in fondo. come possiamo semplificare?

    }

    // questo metodo torna tutti gli utenti e non solo uno. andrebbe aggiunto il metodo findByID. lo ho modificato in getUtenti
    public List<Utente> getUtenti(){
        return utenteRepo.findAll();
    }

    public List<UtenteDTO> getUtentiDto(){

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

                List<Ordine> ordini = ordineRepo.findAll();

                List<OrdineDTO> ordineMatches = new ArrayList<>();
                for (Ordine o : ordini){
                    if(o.getUtente().getId().equals(uDto.getId())){
                        OrdineDTO match = new OrdineDTO();
                        match.setId(o.getId());
                        match.setCodiceOrdine(o.getCodiceOrdine());
                        //match.setVideogiochi(o.getVideogiochi()); probabilmente questa non funzionerà al momento ma la lascio per sistemarla in seguito. bisogna inserire un altro ciclo for per riempirlo.

                        ordineMatches.add(match);
                    }
                }
                //manca il carrello. lo aggiungo in seguito se vogliamo far visualizzare anche quello al front end

                uDto.setOrdiniUtente(ordineMatches);
                utentiDTO.add(uDto);
            }
        }

        return utentiDTO;
    }

    public void deleteUtente(Utente utente){
        utenteRepo.delete(utente);
    }
    public void deleteUtenteById(Long id){
        utenteRepo.deleteById(id);
    }
//    public void updateUtente(Long id,Utente utente){
//        utenteRepo.deleteById(id);
//        utenteRepo.save(utente);
//    }

//    altro metodo per l'update
    public void updateUtente(Utente utente){
        if (utente.getId()==null){
            throw new RuntimeException("Utente non trovato");
        }
        Utente u = new Utente();

        u.setId(utente.getId());
        u.setCodiceUtente(utente.getCodiceUtente());
        u.setNome(utente.getNome());
        u.setCognome(utente.getCognome());
        u.setEmail(utente.getEmail());
        utenteRepo.save(u);
    }

    public Utente updateUtenteDto(UtenteDTO utente){

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

    public Boolean isUtentePresent(Long id){
        Optional<Utente> u = getUtenteById(id);
        return u.isPresent();
    }
}
