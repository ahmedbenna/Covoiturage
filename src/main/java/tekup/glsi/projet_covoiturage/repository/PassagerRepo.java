package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Conducteur;
import tekup.glsi.projet_covoiturage.model.Passager;

import java.util.Optional;

public interface PassagerRepo extends JpaRepository<Passager, Long>  {

    Optional<Passager> findByEmail(String email);
}
