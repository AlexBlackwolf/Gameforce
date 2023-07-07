package com.example.Gameforce.service;

import com.example.Gameforce.entity.Videogioco;
import com.example.Gameforce.repository.VideogiocoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideogiocoService {
    @Autowired
    private VideogiocoRepo videogiocoRepo;

    public void addVideogioco(Videogioco videogioco) {
        videogiocoRepo.save(videogioco);
    }

    public List<Videogioco> getVideogiochi() {
        return videogiocoRepo.findAll();
    }

    public void deleteVideogioco(Videogioco videogioco) {
        videogiocoRepo.delete(videogioco);
    }

    public void deleteVideogiocoById(Long id) {
        videogiocoRepo.deleteById(id);
    }

    public void updateVideogioco(Long id, Videogioco videogioco) {
        videogiocoRepo.deleteById(id);
        videogiocoRepo.save(videogioco);
    }

    public void logicalDelete(Long id) {
        Optional<Videogioco> optionalEntity = videogiocoRepo.findById(id);
        optionalEntity.ifPresent(entity -> {
            entity.setDeleted(true);
            videogiocoRepo.save(entity);

        });
    }
}