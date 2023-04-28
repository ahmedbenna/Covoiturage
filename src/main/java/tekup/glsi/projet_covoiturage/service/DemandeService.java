package tekup.glsi.projet_covoiturage.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.model.Demande;
import tekup.glsi.projet_covoiturage.repository.ConducteurRepo;
import tekup.glsi.projet_covoiturage.repository.DemandeRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class DemandeService {

    private DemandeRepo demandeRepo;



    public Demande getDemandeById (Long id){
        return  demandeRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Demande ID not Found"));
    }



    public List<Demande> getAllDemande(){
        return demandeRepo.findAll();
    }

    public Demande addDemande(Demande demande){
        return demandeRepo.save(demande);
    }

/*    public Demande editDemande(Long id ,Demande demande){

        return demandeRepo.save(demande);

    }*/


    public ResponseEntity<?> deleteDemande (Long id){
        demandeRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
