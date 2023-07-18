package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.LoginDTO;
import com.example.Gameforce.dto.UtenteDTO;
import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.service.UtenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/utente")
public class UtenteController {
    //    http://localhost:8080/swagger-ui/index.html

    @Autowired
    private UtenteService utenteService;

    @PostMapping(value = "/register")
    @Operation(description = "Chiamata per eseguire la registrazione di un cliente")
    @ApiResponse
    private ResponseEntity<?> registerUser(@Valid Utente utente){
        return ResponseEntity.ok(utenteService.registerUtente(utente));
    }
    @GetMapping(value = "/login")
    @Operation(description = "chiamata per effettuare il login")
    @ApiResponse
    private ResponseEntity<?> loginUser(LoginDTO loginDTO){
        return ResponseEntity.ok(utenteService.login(loginDTO));
    }
    @GetMapping(value = "/logout/{id}")
    @Operation(description = "chiamata per effettuare il logout")
    @ApiResponse
    private ResponseEntity<?> logoutUser(@PathVariable Long id){
        return ResponseEntity.ok(utenteService.logout(id));
    }
    @GetMapping(value = "/get-utente/{id}")
    @Operation(description = "Chiamata per visualizzare un utente")
    @ApiResponse
    private ResponseEntity<?> getUtente(@PathVariable Long id){
        return ResponseEntity.ok(utenteService.getUtenteDto(id));
    }
    @GetMapping (value = "/get-utenti")
    @Operation(description = "Chiamata per visualizzare tutti gli utenti")
    @ApiResponse
    private ResponseEntity<?> getListUtenti(){
        return ResponseEntity.ok(utenteService.getUtentiDto());
    }
    @PutMapping("/update-utente/{id}")
    @Operation(description = "Chiamata per modificare un utente")
    @ApiResponse
    private ResponseEntity<?> updateUtente(@PathVariable Long id, @RequestBody UtenteDTO utenteDTO){
        return ResponseEntity.ok(utenteService.updateUtenteDto(utenteDTO));
    }
    @DeleteMapping("/logical-delete-utente/{id}")
    @Operation(description = "Chiamata per effettuare una cancellazione logica")
    @ApiResponse
    private ResponseEntity<?> logicalDeleteUser(@PathVariable Long id){
        utenteService.logicalDelete(id);
        return ResponseEntity.ok("L'utente è stato cancellato, è possibile ripristinarlo entro 3 mesi!");
    }
    @DeleteMapping("/delete-utente/{id}")
    @Operation(description = "Chiamata per eliminare un utente")
    @ApiResponse
    private ResponseEntity<?> deleteUser(@PathVariable Long id){
        utenteService.deleteUtenteById(id);
        return ResponseEntity.ok("L'utente è stato cancellato correttamente!");
    }
    @PostMapping("/create-utente")
    @Operation(description = "Chiamata per inserire un utente")
    @ApiResponse
    private ResponseEntity<?> createUtente(@RequestBody UtenteDTO utenteDTO){
        utenteService.addUtenteDto(utenteDTO);
        return ResponseEntity.ok("L'utente è stato creato correttamente!");
    }

}
