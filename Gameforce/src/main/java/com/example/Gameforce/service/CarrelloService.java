package com.example.Gameforce.service;

import com.example.Gameforce.dto.CarrelloDTO;
import com.example.Gameforce.dto.OrdineDTO;
import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.entity.Ordine;
import com.example.Gameforce.repository.CarrelloRepo;
import com.example.Gameforce.repository.OrdineRepo;
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
    @Autowired
    public OrdineRepo ordineRepo;

    public void addCarrello(CarrelloDTO carrello){
        Carrello c = new Carrello();
        c.setId(carrello.getId());
        c.setCodiceCarrello(carrello.getCodiceCarrello());
        carrelloRepo.save(c);
    }
    public List<CarrelloDTO> getCarrelli() {
        List<Carrello> carrelli = carrelloRepo.findAll();
        List<CarrelloDTO> cDTO = new ArrayList<>();

        for (Carrello carrello : carrelli) {
            CarrelloDTO carrelloDTO = new CarrelloDTO();
            carrelloDTO.setId(carrello.getId());
            carrelloDTO.setCodiceCarrello(carrello.getCodiceCarrello());
            cDTO.add(carrelloDTO);
        }
        return cDTO;
    }
    public Optional<Carrello> getCarrelloById(Long id) {
        return carrelloRepo.findById(id);
    }

    public CarrelloDTO getCarrelloByIdDto(Long id) {
        Optional<Carrello> carrello = carrelloRepo.findById(id);
        if (carrello.isPresent()){
            CarrelloDTO cDto = new CarrelloDTO();
            Carrello c = carrello.get();
            cDto.setId(c.getId());
            cDto.setCodiceCarrello(c.getCodiceCarrello());

            List<Ordine> ordini = ordineRepo.findAll();

            List<OrdineDTO> ordiniMatches = new ArrayList<>();

            for (Ordine o : ordini){
                if(o.getCarrello().getId().equals(cDto.getId())){
                    OrdineDTO match = new OrdineDTO();
                    match.setId(o.getId());
                    match.setCodiceOrdine(o.getCodiceOrdine());

                    ordiniMatches.add(match);
                }
            }

            cDto.setOrdiniCarello(ordiniMatches);
            return cDto;
        }
        return null;
    }

//    public void deleteCarrello(Carrello carrello) {
//        carrelloRepo.delete(carrello);
//    }
    public void deleteCarrelloById(Long id) {
        carrelloRepo.deleteById(id);
    }
//    public void updateCarrello(Carrello carrello){
//        if (carrello.getId()==null){
//            throw new RuntimeException("Carrello non trovato");
//        }
//
//        carrelloRepo.save(carrello);
//    }
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

}


