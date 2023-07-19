package com.example.Gameforce.service;

import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.entity.Videogioco;
import com.example.Gameforce.mapper.VideogiocoMapper;
import com.example.Gameforce.repository.VideogiocoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VideogiocoService {

    @Autowired
    private VideogiocoRepo videogiocoRepo;

    @Autowired
    private VideogiocoMapper mappper;

    public void addVideogiocoDto(VideogiocoDTO videogiocoDTO) {
        videogiocoRepo.save(mappper.toEntity(videogiocoDTO));
    }

    public Optional<Videogioco> getVideogiochiById(Long id) {
        return videogiocoRepo.findById(id);
    }

    public VideogiocoDTO getVidegiocoDtoById(Long id) {
        Optional<Videogioco> videogioco = videogiocoRepo.findById(id);
        if (videogioco.isEmpty())
            return null;
        return mappper.toDto(videogioco.get());
    }

    public List<VideogiocoDTO> getAllVideogioco() {
        List<VideogiocoDTO> videogiochiDto = new ArrayList<>();

        videogiocoRepo.findAll()
                .forEach(v -> videogiochiDto.add(mappper.toDto(v)));

        return videogiochiDto;
    }

    public void deleteVideogioco(VideogiocoDTO videogiocoDTO) {
        videogiocoRepo.delete(mappper.toEntity(videogiocoDTO));
    }

    public void deleteVideogiocoById(Long id) {
        videogiocoRepo.deleteById(id);
    }

    public void updateVideogiocoDto(VideogiocoDTO videogioco) {
        if (videogioco.getId() == null) {
            throw new RuntimeException("Videogico non trovato");
        }
        videogiocoRepo.save(mappper.toEntity(videogioco));
    }

    public void logicalDelete(Long id) {
        Optional<Videogioco> optionalEntity = videogiocoRepo.findById(id);
        optionalEntity.ifPresent(entity -> {
            entity.setDeleted(true);
            videogiocoRepo.save(entity);
        });
    }

    public ResponseEntity<?> makeValutation(Double valutazione, Videogioco v) {
        if (valutazione < 0 || valutazione > 5) {
            ResponseEntity.badRequest()
                    .body("La valutazione deve essere compresa tra 0 e 5, Ã¨ possibile l'uso di valori decimali!");
            if (v.getValutazione() == 0) {
                v.setValutazione(valutazione);
            } else {
                v.setValutazione((v.getValutazione() + valutazione) / 2);
                return ResponseEntity.ok(v.getValutazione());
            }
        }
        return ResponseEntity.badRequest().build();
    }

    public List<Videogioco> getVideogiocoByValutation(Double valutazione) {
        return videogiocoRepo.findByValutazione(valutazione);
    }
}