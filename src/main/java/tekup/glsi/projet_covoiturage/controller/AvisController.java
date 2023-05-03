package tekup.glsi.projet_covoiturage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tekup.glsi.projet_covoiturage.model.Avis;
import tekup.glsi.projet_covoiturage.service.AvisService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/avis/")

public class AvisController {


    private AvisService avisService;



    @GetMapping
    public List<Avis> getAllAvis(){
        return avisService.getAllAvis();
    }

    @GetMapping("{id}")
    public Avis getAvisById (@PathVariable Long id){
        return  avisService.getAvisById(id);
    }

    @GetMapping("conducteur/{id}")
    public List<Avis> getAllConducteurAvis(@PathVariable Long id){
        return avisService.getAllConducteurAvis(id);
    }




    @PostMapping
    public Avis addAvis(@RequestBody Avis avis ){


        return avisService.addAvis(avis);
    }

   /* public Avis editPublication(Long id ,Avis avis){



        return avisRepo.save(avis);

    }*/





    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAvis (@PathVariable Long id){

        return avisService.deleteAvis(id);
    }


}
