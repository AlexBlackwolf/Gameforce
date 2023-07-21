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
    public OrdineRepo ordineRepo;
    @Autowired

    public CarrelloService(CarrelloRepo carrelloRepo, OrdineRepo ordineRepo) {
        this.carrelloRepo = carrelloRepo;
        this.ordineRepo = ordineRepo;
    }
   /* public void svuotaCarrello(Long id){
        CarrelloDTO carrelloOptional= this.getCarrelloById(id);
        carrelloOptional.ifPresent(Carrello::svuotaCarrello);
    }

    public void acquistaCarrello(Long id){
        CarrelloDTO carrelloOptional = this.getCarrelloById(id);
        carrelloOptional.ifPresent(Carrello::acquistaCarrello);
    }*/
    public void addCarrello(CarrelloDTO carrello){
        Carrello c = new Carrello();
        c.setId(carrello.getId());
        c.setCodiceCarrello(carrello.getCodiceCarrello());
        c.setDeleted(false);
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
    public CarrelloDTO getCarrelloById(Long id) {
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

    public void deleteCarrelloById(Long id) {
        carrelloRepo.deleteById(id);
    }
//  tolto carrello.setId
    public void updateCarrello(CarrelloDTO carrello){

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


