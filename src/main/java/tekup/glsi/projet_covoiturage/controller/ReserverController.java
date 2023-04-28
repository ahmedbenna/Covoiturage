package tekup.glsi.projet_covoiturage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tekup.glsi.projet_covoiturage.model.Reserver;
import tekup.glsi.projet_covoiturage.service.ReserverService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/reserver")
public class ReserverController {

    private ReserverService reserverService;

    @GetMapping
    public List<Reserver> getAllReserver(){
        return reserverService.getAllReserver();
    }

    @GetMapping("{id}")
    public Reserver getReserverById (@PathVariable Long id){
        return  reserverService.getReserverById(id);
    }



    @PostMapping
    public Reserver addReserver(@RequestBody Reserver reserver ){

        return reserverService.addReserver(reserver);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteReserver (@PathVariable Long id){

        return reserverService.deleteReserver(id);
    }

}
