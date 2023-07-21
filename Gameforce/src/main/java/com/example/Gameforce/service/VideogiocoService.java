package com.example.Gameforce.service;

import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.entity.Videogioco;
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
    private OrdineService ordineService;


   /* public List<Videogioco> addVideogiocoIntoOrdine(Long idVideogioco,Long idOrdine){
       Optional<Videogioco> videogioco=  this.getVideogiochiById(idVideogioco);
       Optional<Ordine> ordine = ordineService.getOrdineById(idOrdine);
       if(videogioco.isPresent()){
           Videogioco v = videogioco.get();
           ordine.ifPresent(ordine1 -> ordine1.addVideogioco(v));
           return ordine.get().getVideogiochi();
       }
        return null;
    }*/

    public void addVideogioco(VideogiocoDTO videogioco) {
        Videogioco v = new Videogioco();
        v.setCodiceVideogioco(videogioco.getCodiceVideogioco());
        v.setTitolo(videogioco.getTitolo());
        v.setPrezzo(videogioco.getPrezzo());
        v.setValutazione(videogioco.getValutazione());
        v.setDescrizione(videogioco.getDescrizione());
        v.setRequisitiDiSistema(videogioco.getRequisitiDiSistema());
        videogiocoRepo.save(v);
    }

    public VideogiocoDTO getVidegiocoById(Long id) {
        Optional<Videogioco> videogioco = videogiocoRepo.findById(id);
        if (videogioco.isPresent()) {
            VideogiocoDTO vDto = new VideogiocoDTO();
            Videogioco v = videogioco.get();
            vDto.setId(v.getId());
            vDto.setCodiceVideogioco(v.getCodiceVideogioco());
            vDto.setTitolo(v.getTitolo());
            vDto.setPrezzo(v.getPrezzo());
            vDto.setValutazione(v.getValutazione());
            vDto.setDescrizione(v.getDescrizione());
            vDto.setRequisitiDiSistema(v.getRequisitiDiSistema());
            return vDto;
        }
        return null;
    }

    public List<VideogiocoDTO> getAllVideogioco(){
        List<Videogioco> videogiochi = videogiocoRepo.findAll();
        List<VideogiocoDTO> videogiochiDto = new ArrayList<>();

        if (!videogiochi.isEmpty()){
            for (Videogioco v : videogiochi){
                VideogiocoDTO vDto = new VideogiocoDTO();
                vDto.setId(v.getId());
                vDto.setCodiceVideogioco(v.getCodiceVideogioco());
                vDto.setTitolo(v.getTitolo());
                vDto.setPrezzo(v.getPrezzo());
                vDto.setValutazione(v.getValutazione());
                vDto.setDescrizione(v.getDescrizione());
                vDto.setRequisitiDiSistema(v.getRequisitiDiSistema());
                videogiochiDto.add(vDto);
            }
            return videogiochiDto;
        }
        return null;
    }

    public void deleteVideogiocoById(Long id) {
        videogiocoRepo.deleteById(id);
    }

    public void updateVideogioco(VideogiocoDTO videogioco) {
        if (videogioco.getId() == null) {
            throw new RuntimeException("Videogico non trovato");
        }
        Videogioco v = new Videogioco();
        v.setId(videogioco.getId());
        v.setCodiceVideogioco(videogioco.getCodiceVideogioco());
        v.setTitolo(videogioco.getTitolo());
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
            videogiocoRepo.save(entity);
        });
    }
    public ResponseEntity<?> makeValutation(Double valutazione, Videogioco v) {
        if (valutazione < 0 || valutazione > 5) {
            ResponseEntity.badRequest().body("La valutazione deve essere compresa tra 0 e 5, è possibile l'uso di valori decimali!");
            if (v.getValutazione() == 0) {
                v.setValutazione(valutazione);
            } else {
                v.setValutazione((v.getValutazione() + valutazione) / 2);
                return ResponseEntity.ok(v.getValutazione());
            }
        }
        return ResponseEntity.badRequest().build();
    }
    public List<Videogioco> getVideogiocoByValutation(Double valutazione){
        return videogiocoRepo.findByValutazione(valutazione);
    }
}