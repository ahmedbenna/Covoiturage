package tekup.glsi.projet_covoiturage.service;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.repository.ConducteurRepo;
import tekup.glsi.projet_covoiturage.repository.PassagerRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ConducteurService {

    private ConducteurRepo conducteurRepo ;

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

  /*  public Client editPasswordClient(Long idClient, PasswordInfo passwordInfo){
        Client client=getClientById(idClient);
        if (client.getPassword().equals(passwordInfo.getPassword())){
            client.setPassword(passwordInfo.getNewPassword());
            return clientRepo.save(client);
        }
        else {
            throw new RuntimeException("password not valid");
        }
    }*/

   /* public Conducteur authenticateConducteur(Auth auth)
    {
        Conducteur client = getProviderByEmail(auth.getEmail());
        boolean isAuthenticated = false;
        if(client !=null)
        {
            if(client.getPassword().equals(auth.getPassword()))
            {
                isAuthenticated = true;
            }

        }
        if(isAuthenticated)
            return client;
        else
            throw new IllegalArgumentException(" password not valid");

    }*/

    public ResponseEntity<?> deleteConducteur (Long id){
        conducteurRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
