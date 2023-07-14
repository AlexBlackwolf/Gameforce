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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrdineService {
    private OrdineRepo ordineRepo;
    @Autowired
    public OrdineService(OrdineRepo ordineRepo) {
        this.ordineRepo = ordineRepo;
    }

    @Autowired
    private UtenteRepo utenteRepo;

    @Autowired
    private CarrelloRepo carrelloRepo;

    @Autowired
    private VideogiocoRepo videogiocoRepo;

    public Optional<Ordine> getOrdineById(Long id) {
        return ordineRepo.findById(id);
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
    public List<Ordine> getOrdini() {
        return ordineRepo.findAll();
    }

    public void deleteOrdine(Ordine ordine) {
        ordineRepo.delete(ordine);
    }

    public void deleteOrdineById(Long id) {
        ordineRepo.deleteById(id);
    }

    public void updateOrdine(Long id, Ordine ordine) {
        ordineRepo.deleteById(id);
        ordineRepo.save(ordine);
    }

    public void logicalDelete(Long id) {
        Optional<Ordine> optionalEntity = ordineRepo.findById(id);
        optionalEntity.ifPresent(entity -> {
            entity.setDeleted(true);
            ordineRepo.save(entity);
        });
    }

    public Boolean isOrdinePresent(Long id) {
        Optional<Ordine> o = getOrdineById(id);
        return o.isPresent();
    }
}
