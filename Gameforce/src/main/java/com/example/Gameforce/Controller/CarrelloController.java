package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.CarrelloDTO;
import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.service.CarrelloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @Operation(description = "Chiamata per aggiungere un carrello")
    @ApiResponse
    public ResponseEntity<?> addCarrelloDto(@RequestBody CarrelloDTO carrello) {
        carrelloService.addCarrello(carrello);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-all-carrello")
    @Operation(description = "Chimata per visualizzare tutti i  carrelli")
    @ApiResponse
    public ResponseEntity<List<CarrelloDTO>> getCarrelliDto() {
        List<CarrelloDTO> carrelliDto = carrelloService.getCarrelli();
        return ResponseEntity.ok(carrelliDto);
    }

    @GetMapping("/get-carrello/{id}")
    @Operation(description = "Chiamata per visualizzare un carrello tramite id")
    @ApiResponse
    public ResponseEntity<?> getCarrelloById(@PathVariable Long id) {
        Optional<Carrello> carrello = carrelloService.getCarrelloById(id);
        return carrello.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete-carrello/{id}")
    @Operation(description = "Chiamata per cancellare un carrello tramite id")
    @ApiResponse
    public ResponseEntity<?> deleteCarrelloById(@PathVariable Long id) {
        carrelloService.deleteCarrelloById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-carrello/{id}")
    @Operation(description = "Chiamata per modificare un carrello")
    @ApiResponse
    public ResponseEntity<?> updateCarrello(@PathVariable Long id, @RequestBody CarrelloDTO carrello) {
        carrello.setId(id);
        carrelloService.updateCarrelloDto(carrello);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-carrello{id}")
    @Operation(description = "Chiamata per modificare un carrello")
    @ApiResponse
    public ResponseEntity<?> updateCarrelloDto(@PathVariable Long id, @RequestBody CarrelloDTO carrello) {
        carrello.setId(id);
        carrelloService.updateCarrelloDto(carrello);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/carrello/logicalDelete/{id}")
    @Operation(description = "Chiamata per eseguire una cancellazione logica")
    @ApiResponse
    public ResponseEntity<?> logicalDelete(@PathVariable Long id) {
        carrelloService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

}