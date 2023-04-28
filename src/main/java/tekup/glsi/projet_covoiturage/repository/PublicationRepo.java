package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Publication;

public interface PublicationRepo extends JpaRepository<Publication, Long> {
}
