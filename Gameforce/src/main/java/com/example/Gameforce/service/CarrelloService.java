package com.example.Gameforce.service;

import com.example.Gameforce.dto.CarrelloDTO;
import com.example.Gameforce.dto.UtenteDTO;
import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.repository.CarrelloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrelloService {
    private CarrelloRepo carrelloRepo;
    @Autowired
    public CarrelloService(CarrelloRepo carrelloRepo) {
        this.carrelloRepo = carrelloRepo;
    }

    public void addCarrello(Carrello carrello) {
        carrelloRepo.save(carrello);
    }
    public void addCarrelloDto(CarrelloDTO carrello){
        Carrello c = new Carrello();
        c.setCodiceCarrello(carrello.getCodiceCarrello());
        carrelloRepo.save(c);
    }
    public List<Carrello> getCarrelli() {
        return carrelloRepo.findAll();
    }
    public List<CarrelloDTO> getCarrelliDto() {
        List<Carrello> carrelli = carrelloRepo.findAll();
        List<CarrelloDTO> cDTO = new ArrayList<>();

        for (Carrello carrello : carrelli) {
            CarrelloDTO carrelloDTO = new CarrelloDTO();
            carrelloDTO.setCodiceCarrello(carrello.getCodiceCarrello());
            cDTO.add(carrelloDTO);
        }
        return cDTO;
    }
    public Optional<Carrello> getCarrelloById(Long id) {
        return carrelloRepo.findById(id);
    }
    public void deleteCarrello(Carrello carrello) {
        carrelloRepo.delete(carrello);
    }
    public void deleteCarrelloById(Long id) {
        carrelloRepo.deleteById(id);
    }
    public void updateCarrello(Carrello carrello){
        if (carrello.getId()==null){
            throw new RuntimeException("Carrello non trovato");
        }
        Carrello c = new Carrello();
        c.setId(carrello.getId());
        c.setCodiceCarrello(carrello.getCodiceCarrello());

        carrelloRepo.save(c);
    }
    public void updateCarrelloDto(CarrelloDTO carrello){

        if (carrello.getId()==null){
            throw new RuntimeException("Carrello non trovato");
        }
        Carrello c = new Carrello();
        c.setId(carrello.getId());
        c.setCodiceCarrello(carrello.getCodiceCarrello());

        carrelloRepo.save(c);
    }
    public void logicalDelete(Long id){
        Optional<Carrello> optionalEntity = carrelloRepo.findById(id);
        optionalEntity.ifPresent(entity->{entity.setDeleted(true);
            carrelloRepo.save(entity);});
    }
    public Boolean isCarrelloPresent(Long id){
        Optional<Carrello> c = getCarrelloById(id);
        return c.isPresent();
    }
}


