package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Demande;

import java.util.List;

public interface DemandeRepo extends JpaRepository<Demande,Long> {

    List<Demande> findByPassager_IdAndAndReponse(Long id,String reponse);
}
