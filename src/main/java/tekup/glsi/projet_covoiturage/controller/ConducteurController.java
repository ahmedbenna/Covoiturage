package tekup.glsi.projet_covoiturage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.service.ConducteurService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/conducteur")
public class ConducteurController {

    private ConducteurService conducteurService;
    @GetMapping("/{id}")
    public Conducteur getConducteurById (@PathVariable Long id){
        return  conducteurService.getConducteurById(id);
    }


    @GetMapping
    public List<Conducteur> getAllConducteur(){
        return conducteurService.getAllConducteur();
    }

    @PostMapping("/add")
    public Conducteur addConducteur(@RequestBody Conducteur conducteur){
        return conducteurService.addConducteur(conducteur);
    }

    @PutMapping("{id}")
    public Conducteur editConducteur(@PathVariable Long id,
                                     @RequestBody Conducteur conducteur){
        return conducteurService.editConducteur(id,conducteur);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteConducteur (@PathVariable Long id){
        return conducteurService.deleteConducteur(id);
    }
}
