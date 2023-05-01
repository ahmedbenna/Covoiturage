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


    @GetMapping("/{id}")
    public Demande getDemandeById (@PathVariable Long id){
        return  demanderService.getDemandeById(id);
    }



    @GetMapping
    public List<Demande> getAllDemande(){
        return demanderService.getAllDemande();
    }

    @PostMapping("/add")
    public Demande addDemande(@RequestBody Demande demande){
        return demanderService.addDemande(demande);
    }


    @PutMapping("/accepter/{id}")
    public Demande accepterDemande(@PathVariable Long id){

        return demanderService.accepterDemande(id);

    }

    @PutMapping("/rejeter/{id}")
    public Demande rejeterDemande(@PathVariable Long id){


        return demanderService.rejeterDemande(id);

    }

/*    public Demande editDemande(Long id ,Demande demande){

        return demandeRepo.save(demande);

    }*/

    @GetMapping("/publication/{id}")
    public List<Demande> getAllDemandeByPublication(@PathVariable Long id){

        return demanderService.getAllDemandeByPublication(id);

    }

    @GetMapping("/accepter/conducteur/{id}")
    public List<Demande> getAllAcceptersConducteur(@PathVariable Long id){

        return demanderService.getAllAcceptersConducteur(id);

    }

    @GetMapping("/rejeter/conducteur/{id}")
    public List<Demande> getAllRejeterConducter(@PathVariable Long id){

        return demanderService.getAllRejeterConducter(id);

    }

    @GetMapping("/pending/conducteur/{id}")
    public List<Demande> getAllpendingConducter(@PathVariable Long id){
        return demanderService.getAllPendingConducter(id);

    }


    @GetMapping("/accepter/passager/{id}")
    public List<Demande> getAllAcceptersPassager(@PathVariable Long id){

        return demanderService.getAllAcceptersPassager(id);

    }

    @GetMapping("/rejeter/passager/{id}")
    public List<Demande> getAllRejeterPassager(@PathVariable Long id){

        return demanderService.getAllRejeterPassager(id);

    }

    @GetMapping("/pending/passager/{id}")
    public List<Demande> getAllpendingPassager(@PathVariable Long id){

        return demanderService.getAllPendingPassager(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDemande (@PathVariable Long id){
        return demanderService.deleteDemande(id);
    }

}
