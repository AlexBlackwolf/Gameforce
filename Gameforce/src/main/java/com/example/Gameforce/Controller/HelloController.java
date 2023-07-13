package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.UtenteDTO;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private UtenteService utenteService;


    @PostMapping(value = "/post/utente")
    public ResponseEntity<String> addUtente(Utente utente){
        utenteService.addUtente(utente);
        return ResponseEntity.ok("Utente added!");
    }

    @PostMapping(value = "/dto/post/utente", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUtenteDto(@RequestBody UtenteDTO utente){
        utenteService.addUtenteDto(utente);
        return ResponseEntity.ok("Utente added!");
    }

    @GetMapping(value = "/get/utente")
    public ResponseEntity<List<Utente>> getUtenteList(){
        return ResponseEntity.ok(utenteService.getUtenti());
    }

    @GetMapping(value = "/dto/get/utenti")
    public ResponseEntity<List<UtenteDTO>> getUtenteListDto(){
        return ResponseEntity.ok(utenteService.getUtentiDto());
    }

    @GetMapping(value = "dto/get/utente/{id}")
    public ResponseEntity<UtenteDTO> getUtenteDto(@PathVariable Long id){
        if (utenteService.isUtentePresent(id)){
            return ResponseEntity.ok().body(utenteService.getUtenteDto(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(value = "/put/update/{id}")
    public ResponseEntity<?> updateUtente(@PathVariable Long id, @RequestBody Utente u){
        utenteService.updateUtente(u);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/dto/put/update/{id}")
    public ResponseEntity<?> updateUtenteDto(@PathVariable Long id, @RequestBody UtenteDTO u){
        utenteService.updateUtenteDto(u);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete")
    public void deleteLogicById(Long id){
        utenteService.logicalDelete(id);
    }
}
