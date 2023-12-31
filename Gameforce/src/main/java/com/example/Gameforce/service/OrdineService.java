package com.example.Gameforce.service;

import com.example.Gameforce.dto.OrdineDTO;
import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.entity.Ordine;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.entity.Videogioco;
import com.example.Gameforce.repository.CarrelloRepo;
import com.example.Gameforce.repository.OrdineRepo;
import com.example.Gameforce.repository.UtenteRepo;
import com.example.Gameforce.repository.VideogiocoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrdineService {

    private OrdineRepo ordineRepo;
    private UtenteRepo utenteRepo;
    private CarrelloRepo carrelloRepo;
    private VideogiocoRepo videogiocoRepo;

    @Autowired
    public OrdineService(OrdineRepo ordineRepo, UtenteRepo utenteRepo, CarrelloRepo carrelloRepo, VideogiocoRepo videogiocoRepo) {
        this.ordineRepo = ordineRepo;
        this.utenteRepo= utenteRepo;
        this.carrelloRepo=carrelloRepo;
        this.videogiocoRepo=videogiocoRepo;
    }

    /* public void addVideogiocoIntoOrdine(Videogioco videogioco,Long id){
      if(this.getOrdineById(id).isPresent()) {
          this.getOrdineById(id).get().addVideogioco(videogioco);
      }
    }*/

    public void ordineIntoCarrello(Ordine ordine, Long id){
        Optional<Carrello> carrello = carrelloRepo.findById(id);
        if(carrello.isPresent()){
           Carrello c= carrello.get();
           c.addOrdineIntoCarrello(ordine);
        }
    }

    public OrdineDTO getOrdineById(Long id){
        Optional<Ordine> ordine = ordineRepo.findById(id);

        if(ordine.isPresent()){
            OrdineDTO oDto = new OrdineDTO();
            Ordine o = ordine.get();
            oDto.setId(o.getId());
            oDto.setCodiceOrdine(o.getCodiceOrdine());
            oDto.setDataOrdine(o.getDataOrdine());

            List<Videogioco> videogiochi = videogiocoRepo.findAll();

            List<VideogiocoDTO> videogiocoMatches = new ArrayList<>();
            for(Videogioco v : videogiochi){
                if (v.getOrdine().getId().equals(oDto.getId())){
                    VideogiocoDTO match = new VideogiocoDTO();
                    match.setId(v.getId());
                    match.setCodiceVideogioco(v.getCodiceVideogioco());
                    match.setTitolo(v.getTitolo());
                    match.setPrezzo(v.getPrezzo());
                    match.setDescrizione(v.getDescrizione());
                    match.setRequisitiDiSistema(v.getRequisitiDiSistema());
                    match.setValutazione(v.getValutazione());
                    videogiocoMatches.add(match);
                }
            }
            oDto.setVideogiochi(videogiocoMatches);
            return oDto;
        }
        return null;
    }

    public void addOrdine(OrdineDTO ordineDto) {
        Ordine ordine = new Ordine();
        ordine.setDataOrdine(ordineDto.getDataOrdine());
        ordine.setCodiceOrdine(ordineDto.getCodiceOrdine());
        ordine.setDeleted(false);
        ordineRepo.save(ordine);
    }

    // da migliorare
//    tolto long id  e inserito ordine.getId come valore del metodo findById nell'optional, commentato temporaneamente utente,carrello e videogioco.
    public void updateOrdine(OrdineDTO ordineDto) {
        Optional<Ordine> optionalOrdine = ordineRepo.findById(ordineDto.getId());
        if (optionalOrdine.isPresent()) {
            Ordine ordine = optionalOrdine.get();
            ordine.setDataOrdine(ordineDto.getDataOrdine());
            ordine.setCodiceOrdine(ordineDto.getCodiceOrdine());
            ordine.setDeleted(false);

//            Optional<Utente> optionalUtente = utenteRepo.findById(ordineDto.getUtente().getId());
//            if (optionalUtente.isPresent()) {
//                Utente utente = optionalUtente.get();
//                ordine.setUtente(utente);
//            } else {
//                throw new RuntimeException("Utente not found");
//            }
//
//            Optional<Carrello> optionalCarrello = carrelloRepo.findById(ordineDto.getCarrello().getId());
//            if (optionalCarrello.isPresent()) {
//                Carrello carrello = optionalCarrello.get();
//                ordine.setCarrello(carrello);
//            } else {
//                throw new RuntimeException("Carrello not found");
//            }
//
//            List<Videogioco> videogiochi = new ArrayList<>();
//            for (VideogiocoDTO videogiocoDto : ordineDto.getVideogiochi()) {
//                Optional<Videogioco> optionalVideogioco = videogiocoRepo.findById(videogiocoDto.getId());
//                if (optionalVideogioco.isPresent()) {
//                    Videogioco videogioco = optionalVideogioco.get();
//                    videogiochi.add(videogioco);
//                } else {
//                    throw new RuntimeException("Videogioco not found");
//                }
//            }
//            ordine.setVideogiochi(videogiochi);

            ordineRepo.save(ordine);
        } else {
            throw new RuntimeException("Ordine not found");
        }
    }
    // spostato ordineDto dentro il cliclo for e l'if e uscito il return dal ciclo for
    public List<OrdineDTO> getOrdini(){

        List<Ordine> ordini = ordineRepo.findAll();
        List<OrdineDTO> ordiniDto = new ArrayList<>();

        for (Ordine o : ordini){
            if (!ordini.isEmpty()){
                OrdineDTO oDto = new OrdineDTO();
                oDto.setId(o.getId());
                oDto.setCodiceOrdine(o.getCodiceOrdine());
                oDto.setDataOrdine(o.getDataOrdine());
                ordiniDto.add(oDto);
            }
        }
        return ordiniDto;

    }
    public void deleteOrdineById(Long id) {
        ordineRepo.deleteById(id);
    }
    public void logicalDelete(Long id) {
        Optional<Ordine> optionalEntity = ordineRepo.findById(id);
        optionalEntity.ifPresent(entity -> {
            entity.setDeleted(true);
            ordineRepo.save(entity);
        });
    }
}
