package com.example.Gameforce.Controller;

import com.example.Gameforce.dto.VideogiocoDTO;
import com.example.Gameforce.service.VideogiocoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Operation(summary = "Chiamata per aggiungere un videogioco", description = "Questa chiamata ci da la possibilità aggiungere un videogioco nuovo da inserire sul database")
    @ApiResponse
    public ResponseEntity<?> addVideogioco(@RequestBody VideogiocoDTO videogiocoDTO) {
        videogiocoService.addVideogioco(videogiocoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/get-all-videogioco")
    @Operation(summary = "Chiamate per visualizzare tutti i videogiochi", description = "Con questa chiamata visualizziamo una lista contenente tutti gli utenti presenti nel database.")
    @ApiResponse
    public ResponseEntity<?>getAllVideogioco(){
        List<VideogiocoDTO> list = videogiocoService.getAllVideogioco();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/get-videogioco/{id}")
    @Operation(summary = "Chiamata per visualizzare un videogioco", description = "Questa chiamata ci consente di visualizzare un videogioco tramite il parametro di ricerca ID.")
    @ApiResponse
    public ResponseEntity<?> getVideogioco(@PathVariable Long id) {
        VideogiocoDTO videogiocoDTO = videogiocoService.getVidegiocoById(id);
        if (videogiocoDTO != null) {
            return ResponseEntity.ok(videogiocoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete-videogioco/{id}")
    @Operation(summary = "Chiamata per eliminare un videogioco", description = "Con questa chiamata eliminiamo fisicamente un videogioco, ricercandolo col parametro ID, dal database.")
    @ApiResponse
    public ResponseEntity<?> deleteVideogioco(@PathVariable Long id) {
        videogiocoService.deleteVideogiocoById(id);
        return ResponseEntity.noContent().build();
    }
//  tolto videogioco.setId
    @PutMapping("/update-videogioco/{id}")
    @Operation(summary = "Chiamata per modificare un videogioco", description = "Questa chiamata ci consente di modificare i parametri di un videogioco, ricercandolo per id e inserendo i nuovi dati nei campi che desideriamo modificare.")
    @ApiResponse
    public ResponseEntity<?> updateVideogioco(@PathVariable Long id, @RequestBody VideogiocoDTO videogiocoDTO) {
        try {
            videogiocoService.updateVideogioco(videogiocoDTO);
            return ResponseEntity.ok().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/logicalDelete-videogioco/{id}")
    @Operation(summary = "Chiamata per effettuare la cancellazione logica", description = "Questa chiamata ci consente di non visualizzare più un videogioco nelle chiamate API come se fosse cancellato ma viene mantenuto sul database.")
    @ApiResponse
    public ResponseEntity<?> logicalDeleteVideogioco(@PathVariable Long id) {
        videogiocoService.logicalDelete(id);
        return ResponseEntity.noContent().build();
    }

}