package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.entity.Videogioco;
import com.example.Gameforce.service.VideogiocoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/videogioco")
public class VideogiocoController {
    //    http://localhost:8080/swagger-ui/index.html

    private final VideogiocoService videogiocoService;

    @Autowired
    public VideogiocoController(VideogiocoService videogiocoService) {
        this.videogiocoService = videogiocoService;
    }

    @PostMapping("/add-videogioco")
    @Operation(description = "Chiamata per aggiungere un videogioco")
    @ApiResponse
    public ResponseEntity<?> addVideogioco(@RequestBody VideogiocoDTO videogiocoDTO) {
        videogiocoService.addVideogiocoDto(videogiocoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-videogioco/{id}")
    @Operation(description = "Chiamata per visualizzare un videogioco")
    @ApiResponse
    public ResponseEntity<?> getVideogioco(@PathVariable Long id) {
        VideogiocoDTO videogiocoDTO = videogiocoService.getVidegiocoDtoById(id);
        if (videogiocoDTO != null) {
            return ResponseEntity.ok(videogiocoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-videogioco/{id}")
    @Operation(description = "Chiamata per eliminare un videogioco")
    @ApiResponse
    public ResponseEntity<?> deleteVideogioco(@PathVariable Long id) {
        videogiocoService.deleteVideogiocoById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-videogioco/{id}")
    @Operation(description = "Chiamata per modificare un videogioco")
    @ApiResponse
    public ResponseEntity<?> updateVideogioco(@PathVariable Long id, @RequestBody VideogiocoDTO videogiocoDTO) {
        videogiocoDTO.setId(id);
        try {
            videogiocoService.updateVideogiocoDto(videogiocoDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/logicalDelete-videogioco/{id}")
    @Operation(description = "Chiamata per effettuare la cancellazione logica")
    @ApiResponse
    public ResponseEntity<?> logicalDeleteVideogioco(@PathVariable Long id) {
        videogiocoService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

}