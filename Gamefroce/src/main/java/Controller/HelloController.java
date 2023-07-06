package Controller;

import com.example.Gameforce.entity.Utente;
import com.example.Gameforce.utils.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    private UtenteService utenteService;


    @PostMapping(value = "/put/utente")
    public ResponseEntity<String> addUtente(Utente utente){
        utenteService.addUtente(utente);
        return ResponseEntity.ok("Utente added!");
    }
    @GetMapping(value = "/get/utente")
    public ResponseEntity<List<Utente>> getUtenteList(){
        return ResponseEntity.ok(utenteService.getUtente());
    }
    @DeleteMapping(value = "/delete")
    public void deleteLogicById(Long id){
        utenteService.logicalDelete(id);
    }
}
