package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.OrdineDTO;
import com.example.Gameforce.service.OrdineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ordine")
public class OrdineController {
    //    http://localhost:8080/swagger-ui/index.html

    private final OrdineService ordineService;

    @Autowired
    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping("/add-ordine")
    @Operation(summary = "Chiamata per aggiungere un ordine", description = "Questa chiamata ci da la possibilità aggiungere un ordine nuovo da riempire con un utente, carrello e videogioco.")
    @ApiResponse
    public ResponseEntity<?> addOrdine(@RequestBody OrdineDTO ordineDTO) {
        ordineService.addOrdine(ordineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-ordine/{id}")
    @Operation(summary = "Chiamata per aggiungere un ordine", description = "Questa chiamata ci consente di visualizzare un ordine tramite il parametro di ricerca ID.")
    @ApiResponse
    public ResponseEntity<?> getOrdine(@PathVariable Long id) {
        OrdineDTO ordineDTO = ordineService.getOrdineById(id);
        if (ordineDTO != null) {
            return ResponseEntity.ok(ordineDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get-all-ordine")
    @Operation(summary = "Chiamate per visualizzare tutti gli ordini", description = "Con questa chiamata visualizziamo una lista contenente tutti gli ordini presenti nel database.")
    @ApiResponse
    public ResponseEntity<?>getAllOrdini(){
        List<OrdineDTO> list = ordineService.getOrdini();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete-ordine/{id}")
    @Operation(summary = "Chiamata per cancellare un ordine tramite id", description = "Con questa chiamata eliminiamo fisicamente un ordine, ricercandolo col parametro ID, dal database.")
    @ApiResponse
    public ResponseEntity<?> deleteOrdine(@PathVariable Long id) {
        ordineService.deleteOrdineById(id);
        return ResponseEntity.noContent().build();
    }
//  tolto ordine.setId e il parametro id che si passa dal service
    @PutMapping("/update-ordine/{id}")
    @Operation(summary = "Chiamata per modificare un ordine", description = "Questa chiamata ci consente di modificare i parametri di un ordine, ricercandolo per id e inserendo i nuovi dati nei campi che desideriamo modificare.")
    @ApiResponse
    public ResponseEntity<?> updateOrdine(@PathVariable Long id, @RequestBody OrdineDTO ordineDTO) {
        try {
            ordineService.updateOrdine(ordineDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/ordine/logical-delete/{id}")
    @Operation(summary = "Chiamata per eseguire una cancellazione logica", description = "Questa chiamata ci consente di non visualizzare più un ordine nelle chiamate API come se fosse cancellato ma viene mantenuto sul database.")
    @ApiResponse
    public ResponseEntity<?> logicalDeleteOrdine(@PathVariable Long id) {
        ordineService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

}
