package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.OrdineDTO;
import com.example.Gameforce.service.OrdineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ordini")
public class OrdineController {

    private final OrdineService ordineService;

    @Autowired
    public OrdineController(OrdineService ordineService) {
        this.ordineService = ordineService;
    }

    @PostMapping
    public ResponseEntity<Void> addOrdine(@RequestBody OrdineDTO ordineDTO) {
        ordineService.addOrdineDto(ordineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdineDTO> getOrdine(@PathVariable Long id) {
        OrdineDTO ordineDTO = ordineService.getOrdineById(id)
                .map(ordine -> new OrdineDTO(ordine)) // Convert Ordine to OrdineDTO if present
                .orElse(null);
        if (ordineDTO != null) {
            return ResponseEntity.ok(ordineDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrdine(@PathVariable Long id) {
        ordineService.deleteOrdineById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateOrdine(@PathVariable Long id, @RequestBody OrdineDTO ordineDTO) {
        ordineDTO.setId(id);
        try {
            ordineService.updateOrdineDto(id, ordineDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/logical-delete")
    public ResponseEntity<Void> logicalDeleteOrdine(@PathVariable Long id) {
        ordineService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> isOrdinePresent(@PathVariable Long id) {
        Boolean isPresent = ordineService.isOrdinePresent(id);
        return ResponseEntity.ok(isPresent);
    }
}
