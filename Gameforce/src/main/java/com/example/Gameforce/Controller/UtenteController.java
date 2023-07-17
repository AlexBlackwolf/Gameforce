package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.LoginDTO;
import com.example.Gameforce.dto.UtenteDTO;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController(value = "/")
public class UtenteController {
    @Autowired
    private UtenteService utenteService;

    @PostMapping(value = "/register")
    private ResponseEntity<?> registerUser(@Valid Utente utente){
        return ResponseEntity.ok(utenteService.registerUtente(utente));
    }
    @GetMapping(value = "/login")
    private ResponseEntity<?> loginUser(LoginDTO loginDTO){
        return ResponseEntity.ok(utenteService.login(loginDTO));
    }
    @GetMapping(value = "/logout")
    private ResponseEntity<?> logoutUser(Long id){
        return ResponseEntity.ok(utenteService.logout(id));
    }
    @GetMapping(value = "/get-Utente")
    private ResponseEntity<?> getUtente(Long id){
        return ResponseEntity.ok(utenteService.getUtenteDto(id));
    }
    @GetMapping (value = "/get-Utenti")
    private ResponseEntity<?> getListUtenti(){
        return ResponseEntity.ok(utenteService.getUtentiDto());
    }
    @PutMapping("/update-Utente")
    private ResponseEntity<?> updateUtente(UtenteDTO utenteDTO){
        return ResponseEntity.ok(utenteService.updateUtenteDto(utenteDTO));
    }
    @DeleteMapping("/logicalDelete-Utente")
    private ResponseEntity<?> logicalDeleteUser(Long id){
        utenteService.logicalDelete(id);
        return ResponseEntity.ok("L'utente è stato cancellato, è possibile ripristinarlo entro 3 mesi!");
    }
    @DeleteMapping("/delete-Utente")
    private ResponseEntity<?> deleteUser(Long id){
        utenteService.deleteUtenteById(id);
        return ResponseEntity.ok("L'utente è stato cancellato correttamente!");
    }
    @PostMapping("create-Utente")
    private ResponseEntity<?> createUtente(UtenteDTO utenteDTO){
        utenteService.addUtenteDto(utenteDTO);
        return ResponseEntity.ok("L'utente è stato creato correttamente!");
    }

}
