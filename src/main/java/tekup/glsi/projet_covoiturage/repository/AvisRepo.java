package tekup.glsi.projet_covoiturage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tekup.glsi.projet_covoiturage.model.Avis;

import java.util.List;

public interface AvisRepo extends JpaRepository<Avis,Long> {

    List<Avis> findAllByConducteur_Id(Long id);
}
