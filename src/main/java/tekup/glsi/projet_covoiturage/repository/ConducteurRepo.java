package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Conducteur;

import java.util.Optional;

public interface ConducteurRepo extends JpaRepository <Conducteur, Long> {

    Optional<Conducteur> findByEmail(String email);
}
