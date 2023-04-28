package tekup.glsi.projet_covoiturage.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.model.Publication;
import tekup.glsi.projet_covoiturage.model.Reserver;
import tekup.glsi.projet_covoiturage.repository.ReserverRepo;

import java.util.List;

@Service
public class ReserverService {

    private ReserverRepo reserverRepo;

    public List<Reserver> getAllReserver(){
        return reserverRepo.findAll();
    }

    public Reserver getReserverById (Long id){
        return  reserverRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Reserver ID not Found"));
    }



    public Reserver addReserver(Reserver reserver ){

        return reserverRepo.save(reserver);
    }

    public ResponseEntity<?> deleteReserver (Long id){
        reserverRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
