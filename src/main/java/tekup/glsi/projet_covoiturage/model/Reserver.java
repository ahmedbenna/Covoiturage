package tekup.glsi.projet_covoiturage.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Reserver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idConducteur")
    Conducteur conducteur;

    @ManyToOne
    @JoinColumn(name = "idPassager")
    Passager passager;

    @ManyToOne
    @JoinColumn(name = "idPublication")
    Publication publication ;
}
