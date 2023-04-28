package tekup.glsi.projet_covoiturage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tekup.glsi.projet_covoiturage.model.Demande;
import tekup.glsi.projet_covoiturage.service.DemandeService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/demande")
public class DemandeController {

    private DemandeService demanderService;


    @GetMapping("/{id}") public Demande getDemandeById (@PathVariable Long id){
        return  demanderService.getDemandeById(id);
    }



    @GetMapping
    public List<Demande> getAllDemande(){
        return demanderService.getAllDemande();
    }

    @PostMapping("/add")
    public Demande addDemande(Demande demande){
        return demanderService.addDemande(demande);
    }

/*    public Demande editDemande(Long id ,Demande demande){

        return demandeRepo.save(demande);

    }*/


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDemande (Long id){
        return demanderService.deleteDemande(id);
    }

}
