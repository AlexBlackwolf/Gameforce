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
    @Operation(description = "Chiamata per effettuare il login")
    @ApiResponse
    private ResponseEntity<?> loginUser(LoginDTO loginDTO){
        return ResponseEntity.ok(utenteService.login(loginDTO));
    }
    @GetMapping(value = "/logout/{id}")
    @Operation(description = "Chiamata per effettuare il logout")
    @ApiResponse
    private ResponseEntity<?> logoutUser(@PathVariable Long id){
        return ResponseEntity.ok(utenteService.logout(id));
    }
    @GetMapping(value = "/get-utente/{id}")
    @Operation(summary = "Chiamata per visualizzare un utente", description = "Questa chiamata ci consente di visualizzare un utente tramite il parametro di ricerca ID.")
    @ApiResponse
    private ResponseEntity<?> getUtente(@PathVariable Long id){
        return ResponseEntity.ok(utenteService.getUtenteById(id));
    }
    @GetMapping (value = "/get-utenti")
    @Operation(summary = "Chiamata per visualizzare tutti gli utenti", description = "Con questa chiamata visualizziamo una lista contenente tutti gli utenti presenti nel database.")
    @ApiResponse
    private ResponseEntity<?> getListUtenti(){
        return ResponseEntity.ok(utenteService.getUtenti());
    }
    @PutMapping("/update-utente/{id}")
    @Operation(summary = "Chiamata per modificare un utente", description = "Questa chiamata ci consente di modificare i parametri di un utente, ricercandolo per id e inserendo i nuovi dati nei campi che desideriamo modificare.")
    @ApiResponse
    private ResponseEntity<?> updateUtente(@PathVariable Long id, @RequestBody UtenteDTO utenteDTO){
        return ResponseEntity.ok(utenteService.updateUtente(utenteDTO));
    }
    @PatchMapping("/logical-delete-utente/{id}")
    @Operation(summary = "Chiamata per effettuare una cancellazione logica", description = "Questa chiamata ci consente di non visualizzare più un utente nelle chiamate API come se fosse cancellato ma viene mantenuto sul database.")
    @ApiResponse
    private ResponseEntity<?> logicalDeleteUser(@PathVariable Long id){
        utenteService.logicalDelete(id);
        return ResponseEntity.ok("L'utente è stato cancellato, è possibile ripristinarlo entro 3 mesi!");
    }
    @DeleteMapping("/delete-utente/{id}")
    @Operation(summary = "Chiamata per eliminare un utente", description = "Con questa chiamata eliminiamo fisicamente un utente, ricercandolo col parametro ID, dal database.")
    @ApiResponse
    private ResponseEntity<?> deleteUser(@PathVariable Long id){
        utenteService.deleteUtenteById(id);
        return ResponseEntity.ok("L'utente è stato cancellato correttamente!");
    }
    @PostMapping("/create-utente")
    @Operation(summary = "Chiamata per inserire un utente", description = "Questa chiamata ci da la possibilità aggiungere un utente nuovo da inserire sul database")
    @ApiResponse
    private ResponseEntity<?> createUtente(@RequestBody UtenteDTO utenteDTO){
        utenteService.addUtente(utenteDTO);
        return ResponseEntity.ok("L'utente è stato creato correttamente!");
    }

}
