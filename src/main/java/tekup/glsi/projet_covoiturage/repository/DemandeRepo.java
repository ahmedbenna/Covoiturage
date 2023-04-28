package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Demande;

public interface DemandeRepo extends JpaRepository<Demande,Long> {
}
