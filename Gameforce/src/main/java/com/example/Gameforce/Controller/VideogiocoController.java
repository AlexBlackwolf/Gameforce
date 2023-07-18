package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.service.VideogiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videogioco")
public class VideogiocoController {

    private final VideogiocoService videogiocoService;

    @Autowired
    public VideogiocoController(VideogiocoService videogiocoService) {
        this.videogiocoService = videogiocoService;
    }

    @PostMapping("/add-videogioco")
    public ResponseEntity<?> addVideogioco(@RequestBody VideogiocoDTO videogiocoDTO) {
        videogiocoService.addVideogiocoDto(videogiocoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-videogioco")
    public ResponseEntity<?> getVideogioco(@PathVariable Long id) {
        VideogiocoDTO videogiocoDTO = videogiocoService.getVidegiocoDto(id);
        if (videogiocoDTO != null) {
            return ResponseEntity.ok(videogiocoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-videogioco")
    public ResponseEntity<?> deleteVideogioco(@PathVariable Long id) {
        videogiocoService.deleteVideogiocoById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update-videogioco")
    public ResponseEntity<?> updateVideogioco(@PathVariable Long id, @RequestBody VideogiocoDTO videogiocoDTO) {
        videogiocoDTO.setId(id);
        try {
            videogiocoService.updateVideogiocoDto(videogiocoDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/logicalDelete-videogioco")
    public ResponseEntity<?> logicalDeleteVideogioco(@PathVariable Long id) {
        videogiocoService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exists-videogioco")
    public ResponseEntity<?> isVideogiocoPresent(@PathVariable Long id) {
        Boolean isPresent = videogiocoService.isVidegiocoPresent(id);
        return ResponseEntity.ok(isPresent);
    }
}