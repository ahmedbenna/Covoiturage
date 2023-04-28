package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Publication;
import tekup.glsi.projet_covoiturage.model.Reserver;

public interface ReserverRepo extends JpaRepository<Reserver, Long> {
}
