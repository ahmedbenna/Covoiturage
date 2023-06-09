package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Demande;

import java.util.List;

public interface DemandeRepo extends JpaRepository<Demande,Long> {

    List<Demande> findByPassager_IdAndReponse(Long id, String reponse);

    List<Demande> findByPassager_Id(Long id);

    List<Demande> findByConducteur_IdAndReponse(Long id, String reponse);

    List<Demande> findByConducteur_Id(Long id);

    List<Demande> findAllByPublication_Id(Long id);

}
