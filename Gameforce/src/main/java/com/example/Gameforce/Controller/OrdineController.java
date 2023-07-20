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
    @Operation(description = "Chiamata per aggiungere un ordine")
    @ApiResponse
    public ResponseEntity<?> addOrdine(@RequestBody OrdineDTO ordineDTO) {
        ordineService.addOrdine(ordineDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-ordine/{id}")
    @Operation(description = "Chiamata per aggiungere un ordine")
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
    @Operation(description = "chiamate per visualizzare tutti gli ordini")
    @ApiResponse
    public ResponseEntity<?>getAllOrdini(){
        List<OrdineDTO> list = ordineService.getOrdini();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/delete-ordine/{id}")
    @Operation(description = "Chiamata per cancellare un ordine tramite id")
    @ApiResponse
    public ResponseEntity<?> deleteOrdine(@PathVariable Long id) {
        ordineService.deleteOrdineById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-ordine/{id}")
    @Operation(description = "Chiamata per modificare un ordine")
    @ApiResponse
    public ResponseEntity<?> updateOrdine(@PathVariable Long id, @RequestBody OrdineDTO ordineDTO) {
        ordineDTO.setId(id);
        try {
            ordineService.updateOrdine(id, ordineDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/ordine/logical-delete/{id}")
    @Operation(description = "Chiamata per eseguire una cancellazione logica")
    @ApiResponse
    public ResponseEntity<?> logicalDeleteOrdine(@PathVariable Long id) {
        ordineService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

}
