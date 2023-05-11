package tekup.glsi.projet_covoiturage.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tekup.glsi.projet_covoiturage.dto.Auth;
import tekup.glsi.projet_covoiturage.dto.NewPassword;
import tekup.glsi.projet_covoiturage.model.Passager;
import tekup.glsi.projet_covoiturage.service.PassagerService;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/passager")
public class PassagerController {


    private PassagerService passagerService;

    @GetMapping("{id}")
    public Passager getPassagerById (@PathVariable Long id){
        return  passagerService.getPassagerById(id);
    }



    @GetMapping
    public List<Passager> getAllPassager(){
        return passagerService.getAllPassager();
    }

    @PostMapping
    public Passager addPassager(@RequestBody Passager passager){
        return passagerService.addPassager(passager);
    }

    @PutMapping("{id}")
    public Passager editClient(@PathVariable Long id ,Passager passager){

        return passagerService.editClient(id,passager);

    }

    @PostMapping("auth")
    public Passager authenticatePassager(@RequestBody Auth auth)
    {
        return passagerService.authenticatePassager(auth);
    }

    @PutMapping("/{id}/password")
    public Passager editPasswordPassager(@PathVariable Long id, @RequestBody NewPassword newPassword){

            return passagerService.editPasswordPassager(id, newPassword);
        }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deletePassager (@PathVariable Long id){
        return passagerService.deletePassager(id);
    }

}
