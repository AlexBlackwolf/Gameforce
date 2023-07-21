package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.CarrelloDTO;
import com.example.Gameforce.service.CarrelloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {
    //    http://localhost:8080/swagger-ui/index.html

    private final CarrelloService carrelloService;

    @Autowired
    public CarrelloController(CarrelloService carrelloService) {
        this.carrelloService = carrelloService;
    }

    @PostMapping("/add-carrello")
    @Operation(summary = "Chiamata per aggiungere un carrello", description = "Questa chiamata ci da la possibilità aggiungere un carrello nuovo da riempire con un utente, ordine e videogioco.")
    @ApiResponse
    public ResponseEntity<?> addCarrelloDto(@RequestBody CarrelloDTO carrello) {
        carrelloService.addCarrello(carrello);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-all-carrello")
    @Operation(summary = "Chimata per visualizzare tutti i  carrelli", description = "Con questa chiamata visualizziamo una lista contenente tutti i carrelli presenti nel database.")
    @ApiResponse
    public ResponseEntity<List<CarrelloDTO>> getCarrelliDto() {
        List<CarrelloDTO> carrelliDto = carrelloService.getCarrelli();
        return ResponseEntity.ok(carrelliDto);
    }

    @GetMapping("/get-carrello/{id}")
    @Operation(summary = "Chiamata per visualizzare un carrello tramite id", description = "Questa chiamata ci consente di visualizzare un carrello tramite il parametro di ricerca ID.")
    @ApiResponse
    public ResponseEntity<?> getCarrelloById(@PathVariable Long id) {
        CarrelloDTO carrelloDTO = carrelloService.getCarrelloById(id);
        if (carrelloDTO != null) {
            return ResponseEntity.ok(carrelloDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-carrello/{id}")
    @Operation(summary = "Chiamata per cancellare un carrello tramite id", description = "Con questa chiamata eliminiamo fisicamente un carrello, ricercandolo col parametro ID, dal database.")
    @ApiResponse
    public ResponseEntity<?> deleteCarrelloById(@PathVariable Long id) {
        carrelloService.deleteCarrelloById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-carrello/{id}")
    @Operation(summary = "Chiamata per modificare un carrello", description = "Questa chiamata ci consente di modificare i parametri di un carrello, ricercandolo per id e inserendo i nuovi dati nei campi che desideriamo modificare.")
    @ApiResponse
    public ResponseEntity<?> updateCarrello(@PathVariable Long id, @RequestBody CarrelloDTO carrello) {
        carrelloService.updateCarrello(carrello);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/carrello/logicalDelete/{id}")
    @Operation(summary = "Chiamata per eseguire una cancellazione logica", description = "Questa chiamata ci consente di non visualizzare più un carrello nelle chiamate API come se fosse cancellato ma viene mantenuto sul database.")
    @ApiResponse
    public ResponseEntity<?> logicalDelete(@PathVariable Long id) {
        carrelloService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

}