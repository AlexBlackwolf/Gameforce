package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.CarrelloDTO;
import com.example.Gameforce.entity.Carrello;
import com.example.Gameforce.service.CarrelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrello")
public class CarrelloController {

    private final CarrelloService carrelloService;

    @Autowired
    public CarrelloController(CarrelloService carrelloService) {
        this.carrelloService = carrelloService;
    }

    @PostMapping("/add-carrello")
    public ResponseEntity<?> addCarrello(@RequestBody Carrello carrello) {
        carrelloService.addCarrello(carrello);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/add-dto-carrello")
    public ResponseEntity<?> addCarrelloDto(@RequestBody CarrelloDTO carrello) {
        carrelloService.addCarrelloDto(carrello);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-all-carrello")
    public ResponseEntity<List<Carrello>> getCarrelli() {
        List<Carrello> carrelli = carrelloService.getCarrelli();
        return ResponseEntity.ok(carrelli);
    }

    @GetMapping("/get-dto-carrello")
    public ResponseEntity<List<CarrelloDTO>> getCarrelliDto() {
        List<CarrelloDTO> carrelliDto = carrelloService.getCarrelliDto();
        return ResponseEntity.ok(carrelliDto);
    }

    @GetMapping("/get-id-carrello")
    public ResponseEntity<?> getCarrelloById(@PathVariable Long id) {
        Optional<Carrello> carrello = carrelloService.getCarrelloById(id);
        return carrello.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete-id-carrello")
    public ResponseEntity<?> deleteCarrelloById(@PathVariable Long id) {
        carrelloService.deleteCarrelloById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-carrello")
    public ResponseEntity<?> updateCarrello(@PathVariable Long id, @RequestBody Carrello carrello) {
        carrello.setId(id);
        carrelloService.updateCarrello(carrello);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-dto-carrello")
    public ResponseEntity<?> updateCarrelloDto(@PathVariable Long id, @RequestBody CarrelloDTO carrello) {
        carrello.setId(id);
        carrelloService.updateCarrelloDto(carrello);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/carrello/logicalDelete")
    public ResponseEntity<?> logicalDelete(@PathVariable Long id) {
        carrelloService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/carrello/isPresent")
    public ResponseEntity<?> isCarrelloPresent(@PathVariable Long id) {
        Boolean isPresent = carrelloService.isCarrelloPresent(id);
        return ResponseEntity.ok(isPresent);
    }
}