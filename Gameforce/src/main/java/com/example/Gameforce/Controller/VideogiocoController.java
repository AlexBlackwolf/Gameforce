package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.service.VideogiocoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/videogames")
public class VideogiocoController {

    private final VideogiocoService videogiocoService;

    @Autowired
    public VideogiocoController(VideogiocoService videogiocoService) {
        this.videogiocoService = videogiocoService;
    }

    @PostMapping
    public ResponseEntity<Void> addVideogioco(@RequestBody VideogiocoDTO videogiocoDTO) {
        videogiocoService.addVideogiocoDto(videogiocoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideogiocoDTO> getVideogioco(@PathVariable Long id) {
        VideogiocoDTO videogiocoDTO = videogiocoService.getVidegiocoDto(id);
        if (videogiocoDTO != null) {
            return ResponseEntity.ok(videogiocoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideogioco(@PathVariable Long id) {
        videogiocoService.deleteVideogiocoById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVideogioco(@PathVariable Long id, @RequestBody VideogiocoDTO videogiocoDTO) {
        videogiocoDTO.setId(id);
        try {
            videogiocoService.updateVideogiocoDto(videogiocoDTO);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/logical-delete")
    public ResponseEntity<Void> logicalDeleteVideogioco(@PathVariable Long id) {
        videogiocoService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/exists")
    public ResponseEntity<Boolean> isVideogiocoPresent(@PathVariable Long id) {
        Boolean isPresent = videogiocoService.isVidegiocoPresent(id);
        return ResponseEntity.ok(isPresent);
    }
}