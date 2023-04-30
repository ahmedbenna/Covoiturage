package tekup.glsi.projet_covoiturage.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String reponse;

    @ManyToOne
    @JoinColumn(name = "idPassager")
    Passager passager;

    @ManyToOne
    @JoinColumn(name = "idPublication")
    Publication publication ;

    @ManyToOne
    @JoinColumn(name = "idConducteur")
    Conducteur conducteur;
}
