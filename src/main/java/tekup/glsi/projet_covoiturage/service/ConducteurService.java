package tekup.glsi.projet_covoiturage.service;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.dto.Auth;
import tekup.glsi.projet_covoiturage.dto.NewPassword;
import tekup.glsi.projet_covoiturage.model.Avis;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.model.Demande;
import tekup.glsi.projet_covoiturage.model.Publication;
import tekup.glsi.projet_covoiturage.repository.*;

import java.util.List;

@Service
@AllArgsConstructor
public class ConducteurService {

    private ConducteurRepo conducteurRepo ;

    private DemandeRepo demandeRepo;
    private PublicationRepo publicationRepo;
    private AvisRepo avisRepo;

    public Conducteur getConducteurById (Long id){
        return  conducteurRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Conducteur ID not Found"));
    }

    public Conducteur getConducteurByEmail (String email){
        Conducteur conducteur =  conducteurRepo.findByEmail(email).
                orElseThrow(()-> new IllegalArgumentException("Conducteur email not Found"));
        return conducteur;
    }

    public List<Conducteur> getAllConducteur(){
        return conducteurRepo.findAll();
    }

    public Conducteur addConducteur(Conducteur conducteur){
       /* City city=cityService.getCityById(client.getCity().getIdCity());
        client.setCity(city);*/
        // client.setPassword(passwordEncoder.encode(client.getPassword()));
        return conducteurRepo.save(conducteur);
    }

    public Conducteur editConducteur(Long id ,Conducteur conducteur){
        Conducteur conducteur1 = getConducteurById(id);
        conducteur1.setNom(conducteur.getNom());
        conducteur1.setPrenom(conducteur.getPrenom());
        conducteur1.setEmail(conducteur.getEmail());
        conducteur1.setTelephone(conducteur.getTelephone());
        conducteur1.setDateDeNaissance(conducteur.getDateDeNaissance());
        conducteur1.setAdresse(conducteur.getAdresse());
        return conducteurRepo.save(conducteur1);

    }

    public Conducteur editPasswordConducteur(Long id, NewPassword newPassword){
        Conducteur conducteur =getConducteurById(id);
        if (conducteur.getPassword().equals(newPassword.getPassword())){
            conducteur.setPassword(newPassword.getNewPassword());
            return conducteurRepo.save(conducteur);
        }
        else {
            throw new RuntimeException("password not valid");
        }
    }

   public Conducteur authenticateConducteur(Auth auth)
    {
        Conducteur conducteur = getConducteurByEmail(auth.getEmail());
        boolean isAuthenticated = false;
        if(conducteur !=null)
        {
            if(conducteur.getPassword().equals(auth.getPassword()))
            {
                isAuthenticated = true;
            }

        }
        if(isAuthenticated)
            return conducteur;
        else
            throw new IllegalArgumentException(" password not valid");

    }

    public ResponseEntity<?> deleteConducteur (Long id){

        List<Demande> demandes=demandeRepo.findByConducteur_Id(id);
        for (Demande demande: demandes) {
            demandeRepo.deleteById(demande.getId());
        }

        List<Publication> publications=publicationRepo.findAllByConducteur_Id(id);
        for (Publication publication : publications) {
            publicationRepo.deleteById(publication.getId());
        }

        List<Avis> avisList =avisRepo.findAllByConducteur_Id(id);
        for (Avis avis: avisList) {
            avisRepo.deleteById(avis.getId());
        }

        conducteurRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
