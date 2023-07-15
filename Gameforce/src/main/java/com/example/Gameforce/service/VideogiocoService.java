package com.example.Gameforce.service;

import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.entity.Videogioco;
import com.example.Gameforce.repository.VideogiocoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class VideogiocoService {

    private VideogiocoRepo videogiocoRepo;

    @Autowired
    public VideogiocoService(VideogiocoRepo videogiocoRepo) {this.videogiocoRepo = videogiocoRepo;}

    public void addVideogiocoDto(VideogiocoDTO videogioco) {
        Videogioco v = new Videogioco();
        v.setCodiceVideogioco(videogioco.getCodiceVideogioco());
        videogioco.getGeneri().forEach(g->v.addGeneri(g));
        v.setTitolo(videogioco.getTitolo());
        v.setPiattaforma(videogioco.getPiattaforma());
        v.setPrezzo(videogioco.getPrezzo());
        v.setValutazione(videogioco.getValutazione());
        v.setDescrizione(videogioco.getDescrizione());
        v.setRequisitiDiSistema(videogioco.getRequisitiDiSistema());
        videogiocoRepo.save(v);
    }
    public Optional<Videogioco> getVideogiochiById(Long id) {
        return videogiocoRepo.findById(id);
    }
    public VideogiocoDTO getVidegiocoDto (Long id) {
        Optional<Videogioco> videogioco = videogiocoRepo.findById(id);
        if(videogioco.isPresent()){
            VideogiocoDTO vDto = new VideogiocoDTO();
            Videogioco v = videogioco.get();
            vDto.setId(v.getId());
            vDto.setCodiceVideogioco(v.getCodiceVideogioco());
            vDto.setGeneri(v.getGeneri());
            vDto.setTitolo(v.getTitolo());
            vDto.setPiattaforma(v.getPiattaforma());
            vDto.setPrezzo(v.getPrezzo());
            vDto.setValutazione(v.getValutazione());
            vDto.setDescrizione(v.getDescrizione());
            vDto.setRequisitiDiSistema(v.getRequisitiDiSistema());
            return vDto;
        }
        return null;
    }
    public void deleteVideogioco(Videogioco videogioco) {
        videogiocoRepo.delete(videogioco);
    }
    public void deleteVideogiocoById(Long id) {
        videogiocoRepo.deleteById(id);
    }
    public void updateVideogiocoDto(VideogiocoDTO videogioco){
        if(videogioco.getId()==null){
            throw new RuntimeException("Videogico non trovato");
        }
        Videogioco v = new Videogioco();
        v.setCodiceVideogioco(videogioco.getCodiceVideogioco());
        videogioco.getGeneri().forEach(g->v.addGeneri(g));
        v.setTitolo(videogioco.getTitolo());
        v.setPiattaforma(videogioco.getPiattaforma());
        v.setPrezzo(videogioco.getPrezzo());
        v.setValutazione(videogioco.getValutazione());
        v.setDescrizione(videogioco.getDescrizione());
        v.setRequisitiDiSistema(videogioco.getRequisitiDiSistema());
        videogiocoRepo.save(v);
    }
    public void logicalDelete(Long id) {
        Optional<Videogioco> optionalEntity = videogiocoRepo.findById(id);
        optionalEntity.ifPresent(entity -> {
            entity.setDeleted(true);
            videogiocoRepo.save(entity);});
    }
    public Boolean isVidegiocoPresent (Long id) {
        Optional<Videogioco> v = getVideogiochiById(id);
        return v.isPresent();
    }
}