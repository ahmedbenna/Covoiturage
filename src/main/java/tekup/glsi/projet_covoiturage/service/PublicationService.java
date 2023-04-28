package tekup.glsi.projet_covoiturage.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.model.Passager;
import tekup.glsi.projet_covoiturage.model.Publication;
import tekup.glsi.projet_covoiturage.repository.PublicationRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {

    private PublicationRepo publicationRepo;
    private ConducteurService conducteurService;


    public List<Publication> getAllPublication(){
        return publicationRepo.findAll();
    }

    public Publication getPublicationById (Long id){
        return  publicationRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Publication ID not Found"));
    }



    public Publication addPublication(Long id,Publication publication){

        Conducteur conducteur=conducteurService.getConducteurById(id);
        publication.setConducteur(conducteur);

        return publicationRepo.save(publication);
    }

    public Publication editPublication(Long id ,Publication publication){
        Publication publication1 = getPublicationById(id);
        publication1.setDescription(publication.getDescription());
        publication1.setPrix((publication.getPrix()));
        publication1.setDateDepart(publication.getDateDepart());
        publication1.setLieuArrive(publication.getLieuArrive());
        publication1.setNbrePlace(publication.getNbrePlace());

        return publicationRepo.save(publication1);

    }





    public ResponseEntity<?> deletePublication (Long id){
        publicationRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
