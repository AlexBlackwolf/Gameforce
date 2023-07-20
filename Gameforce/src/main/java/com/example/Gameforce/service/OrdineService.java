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
    @Autowired
    private OrdineRepo ordineRepo;

    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private CarrelloRepo carrelloRepo;

    @Autowired
    private VideogiocoRepo videogiocoRepo;


    public Optional<Ordine> getOrdineById(Long id) {
        return ordineRepo.findById(id);
    }

    public void addVideogiocoIntoOrdine(Videogioco videogioco,Long id){
      if(this.getOrdineById(id).isPresent()) {
          this.getOrdineById(id).get().addVideogioco(videogioco);
      }
    }

    public void ordineIntoCarrello(Ordine ordine, Long id){
        Optional<Carrello> carrello = carrelloRepo.findById(id);
        if(carrello.isPresent()){
           Carrello c= carrello.get();
           c.addOrdineIntoCarrello(ordine);
        }
    }

    public OrdineDTO getOrdineDtoById(Long id){
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
                    match.setGeneri(v.getGeneri());
                    match.setPiattaforma(v.getPiattaforma());
                    match.setPrezzo(v.getPrezzo());
                    match.setDescrizione(v.getDescrizione());
                    match.setRequisitiDiSistema(v.getRequisitiDiSistema());

                    videogiocoMatches.add(match);

                }
            }

            oDto.setVideogiochi(videogiocoMatches);
            return oDto;
        }


        return null;
    }

    public void addOrdineDto(OrdineDTO ordineDto) {
        Ordine ordine = new Ordine();
        ordine.setDataOrdine(ordineDto.getDataOrdine());
        ordine.setCodiceOrdine(ordineDto.getCodiceOrdine());

        Optional<Utente> optionalUtente = utenteRepo.findById(ordineDto.getUtente().getId());
        if (optionalUtente.isPresent()) {
            Utente utente = optionalUtente.get();
            ordine.setUtente(utente);
        } else {
            throw new RuntimeException("Utente not found");
        }

        Optional<Carrello> optionalCarrello = carrelloRepo.findById(ordineDto.getCarrello().getId());
        if (optionalCarrello.isPresent()) {
            Carrello carrello = optionalCarrello.get();
            ordine.setCarrello(carrello);
        } else {
            throw new RuntimeException("Carrello not found");
        }

        VideogiocoService videogiocoService = new VideogiocoService();

        VideogiocoDTO vDto = new VideogiocoDTO();
        ordine.setVideogiochi(videogiocoService.addVideogiocoIntoOrdine(vDto.getId(), ordineDto.getId()));
//        List<Videogioco> videogiochi = new ArrayList<>();
//        for (VideogiocoDTO videogiocoDto : ordineDto.getVideogiochi()) {
//            Optional<Videogioco> optionalVideogioco = videogiocoRepo.findById(videogiocoDto.getId());
//            if (optionalVideogioco.isPresent()) {
//                Videogioco videogioco = optionalVideogioco.get();
//                videogiochi.add(videogioco);
//            } else {
//                throw new RuntimeException("Videogioco not found");
//            }
//        }
//        ordine.setVideogiochi(videogiochi);

        ordineRepo.save(ordine);
    }

    public void updateOrdineDto(Long id, OrdineDTO ordineDto) {
        Optional<Ordine> optionalOrdine = ordineRepo.findById(id);
        if (optionalOrdine.isPresent()) {
            Ordine ordine = optionalOrdine.get();
            ordine.setDataOrdine(ordineDto.getDataOrdine());
            ordine.setCodiceOrdine(ordineDto.getCodiceOrdine());

            Optional<Utente> optionalUtente = utenteRepo.findById(ordineDto.getUtente().getId());
            if (optionalUtente.isPresent()) {
                Utente utente = optionalUtente.get();
                ordine.setUtente(utente);
            } else {
                throw new RuntimeException("Utente not found");
            }

            Optional<Carrello> optionalCarrello = carrelloRepo.findById(ordineDto.getCarrello().getId());
            if (optionalCarrello.isPresent()) {
                Carrello carrello = optionalCarrello.get();
                ordine.setCarrello(carrello);
            } else {
                throw new RuntimeException("Carrello not found");
            }

            List<Videogioco> videogiochi = new ArrayList<>();
            for (VideogiocoDTO videogiocoDto : ordineDto.getVideogiochi()) {
                Optional<Videogioco> optionalVideogioco = videogiocoRepo.findById(videogiocoDto.getId());
                if (optionalVideogioco.isPresent()) {
                    Videogioco videogioco = optionalVideogioco.get();
                    videogiochi.add(videogioco);
                } else {
                    throw new RuntimeException("Videogioco not found");
                }
            }
            ordine.setVideogiochi(videogiochi);

            ordineRepo.save(ordine);
        } else {
            throw new RuntimeException("Ordine not found");
        }
    }

    public void updateOrdine(Long id, Ordine ordine) {
        ordineRepo.deleteById(id);
        ordineRepo.save(ordine);
    }

    public List<Ordine> getOrdini() {
        return ordineRepo.findAll();
    }

    public List<OrdineDTO> getOrdiniDto(){
        List<Ordine> ordini = ordineRepo.findAll();

        List<OrdineDTO> ordiniDto = new ArrayList<>();

        OrdineDTO oDto = new OrdineDTO();

        for (Ordine o : ordini){
            if (!ordini.isEmpty()){
                oDto.setId(o.getId());
                oDto.setCodiceOrdine(o.getCodiceOrdine());
                oDto.setDataOrdine(o.getDataOrdine());

                ordiniDto.add(oDto);
                return ordiniDto;
            }
        }

        return null;
    }

    //questo metodo si potrebbe fare passando ordineDto e fare sempre il deleteById
    public void deleteOrdine(Ordine ordine) {
        ordineRepo.delete(ordine);
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
