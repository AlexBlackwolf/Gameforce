package com.example.Gameforce.service;

import com.example.Gameforce.entity.Ordine;
import com.example.Gameforce.repository.OrdineRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OrdineService {
    @Autowired
    private OrdineRepo ordineRepo;

    public void addOrdine(Ordine ordine) {
        ordineRepo.save(ordine);
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
}
