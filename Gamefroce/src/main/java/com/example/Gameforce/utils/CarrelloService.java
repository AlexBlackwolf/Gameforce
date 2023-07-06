package com.example.Gameforce.utils;

import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.repository.CarrelloRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrelloService extends EntityTrackingService {
    private CarrelloRepo carrelloRepo;
    @Autowired
    public CarrelloService(CarrelloRepo carrelloRepo) {
        this.carrelloRepo = carrelloRepo;
    }

    public void addCarrello(Carrello carrello) {
        carrelloRepo.save(carrello);
    }

    public List<Carrello> getAllCarrelli() {
        return carrelloRepo.findAll();
    }

    public Carrello getCarrelloById(Long id) {
        return carrelloRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrello non trovato"));
    }

    public void deleteCarrello(Carrello carrello) {
        carrelloRepo.delete(carrello);
    }

    public void deleteCarrelloById(Long id) {
        carrelloRepo.deleteById(id);
    }

    public void updateCarrello(Long id, Carrello updatedCarrello) {
        Carrello existingCarrello = carrelloRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrello non trovato"));

        existingCarrello.setCodiceCarrello(updatedCarrello.getCodiceCarrello());
        existingCarrello.setOrdiniCarello(updatedCarrello.getOrdiniCarello());

        carrelloRepo.save(existingCarrello);
    }
}


