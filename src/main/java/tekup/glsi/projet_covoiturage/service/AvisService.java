package tekup.glsi.projet_covoiturage.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.model.Avis;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.model.Publication;
import tekup.glsi.projet_covoiturage.repository.AvisRepo;

import java.util.List;

@Service
public class AvisService {

    private AvisRepo avisRepo;
    private ConducteurService conducteurService;

    public List<Avis> getAllAvis(){
        return avisRepo.findAll();
    }

    public List<Avis> getAllConducteurAvis(Long id){
        return avisRepo.findAllByConducteur_Id(id);
    }



    public Avis getAvisById (Long id){
        return  avisRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Avis ID not Found"));
    }



    public Avis addAvis(Avis avis ){

        Conducteur conducteur=conducteurService.getConducteurById(avis.getConducteur().getId());

        int numb= conducteur.getNumbNote();
        double f=(conducteur.getNote()*numb)+avis.getNote();
        numb++;
        f=f/numb;
        conducteur.setNote(f);
        conducteur.setNumbNote(conducteur.getNumbNote()+1);

        conducteurService.editConducteur(conducteur.getId(), conducteur);


        return avisRepo.save(avis);
    }

   /* public Avis editPublication(Long id ,Avis avis){



        return avisRepo.save(avis);

    }*/





    public ResponseEntity<?> deleteAvis (Long id){
        avisRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
