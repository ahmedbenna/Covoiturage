package tekup.glsi.projet_covoiturage.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.model.Publication;
import tekup.glsi.projet_covoiturage.repository.PublicationRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {

    private PublicationRepo publicationRepo;
    private ConducteurService conducteurService;


    public List<Publication> getAllPublication(){
        return publicationRepo.findAll();
    }

    public List<Publication> getAllConducteurPublication(Long id){
        return publicationRepo.findAllByConducteur_Id(id);
    }

    public List<Publication> getAllPublicationDispo(){
        return publicationRepo.findByDateDepartAfterAndNbrePlaceGreaterThan(LocalDateTime.now(),0);
    }


    public List<Publication> getAllPublicationDispoLieu(String lieuD, String lieuA) {

        List<Publication> publications=getAllPublicationDispo();
        List<Publication> publicationList=new ArrayList<>();

        if (lieuD.equals("")&&lieuA.equals("")) {
            return publicationList;
        }
        else if (lieuD.equals("")){

            for (Publication publication : publications) {

                if ((lieuA.toLowerCase().contains(publication.getLieuArrive().toLowerCase()))) {

                    publicationList.add(publication);
                }

                if ((publication.getLieuArrive().toLowerCase().contains(lieuA.toLowerCase()))) {

                    publicationList.add(publication);
                }
            }

            return publicationList;

        }
        else if (lieuA.equals("")){
            for (Publication publication : publications) {

                if ((lieuD.toLowerCase().contains(publication.getLieuDepart().toLowerCase())) ) {

                    publicationList.add(publication);
                }

                if ((publication.getLieuDepart().toLowerCase()).contains(lieuD.toLowerCase()) ) {

                    publicationList.add(publication);
                }
            }


        }

        else {
            for (Publication publication : publications) {

                if ((lieuD.toLowerCase().contains(publication.getLieuDepart().toLowerCase())) ||
                        (lieuA.toLowerCase().contains(publication.getLieuArrive().toLowerCase()))) {

                    publicationList.add(publication);
                }

                if ((publication.getLieuDepart().toLowerCase()).contains(lieuD.toLowerCase()) ||
                        (publication.getLieuArrive().toLowerCase().contains(lieuA.toLowerCase()))) {

                    publicationList.add(publication);
                }
            }
        }

        return publicationList;
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
