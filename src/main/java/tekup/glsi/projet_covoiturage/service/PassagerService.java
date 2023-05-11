package tekup.glsi.projet_covoiturage.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tekup.glsi.projet_covoiturage.dto.Auth;
import tekup.glsi.projet_covoiturage.dto.NewPassword;
import tekup.glsi.projet_covoiturage.model.Passager;
import tekup.glsi.projet_covoiturage.repository.PassagerRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class PassagerService {


    private PassagerRepo passagerRepo;


    public Passager getPassagerById (Long id){
        return  passagerRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Passager ID not Found"));
    }

    public Passager getPassagerByEmail (String email){
        Passager passager =  passagerRepo.findByEmail(email).
                orElseThrow(()-> new IllegalArgumentException("Passager email not Found"));
        return passager;
    }

    public List<Passager> getAllPassager(){
        return passagerRepo.findAll();
    }

    public Passager addPassager(Passager passager){
       /* City city=cityService.getCityById(client.getCity().getIdCity());
        client.setCity(city);*/
        // client.setPassword(passwordEncoder.encode(client.getPassword()));
        return passagerRepo.save(passager);
    }

    public Passager editClient(Long id ,Passager passager){
        Passager passager1 = getPassagerById(id);
        passager1.setPrenom(passager.getPrenom());
        passager1.setNom(passager.getNom());
        passager1.setEmail(passager.getEmail());
        passager1.setTelephone(passager.getTelephone());
        passager1.setDateDeNaissance(passager.getDateDeNaissance());
        passager1.setAdresse(passager.getAdresse());
        return passagerRepo.save(passager1);

    }

    public Passager editPasswordPassager(Long id, NewPassword newPassword){
        Passager passager =getPassagerById(id);
        if (passager.getPassword().equals(newPassword.getPassword())){
            passager.setPassword(newPassword.getNewPassword());
            /*try {
                this.mailSenderService.send(client.getEmail(),
                        "Modfication de mot de passe  ",
                        "Bonjour,<br>\n " +
                                "Votre mot de passe a été changé.<br>\n " +
                                "Merci pour votre confiance.<br>\n" +
                                " Cordialement");

            } catch (MessagingException e) {
                e.printStackTrace();
            }*/
            return passagerRepo.save(passager);
        }
        else {
            throw new RuntimeException("password not valid");
        }
    }

    public Passager authenticatePassager(Auth auth)
    {
        Passager passager = getPassagerByEmail(auth.getEmail());
        boolean isAuthenticated = false;
        if(passager !=null)
        {
            if(passager.getPassword().equals(auth.getPassword()))
            {
                isAuthenticated = true;
            }

        }
        if(isAuthenticated)
            return passager;
        else
            throw new IllegalArgumentException(" password not valid");

    }

    public ResponseEntity<?> deletePassager (Long id){
        passagerRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
