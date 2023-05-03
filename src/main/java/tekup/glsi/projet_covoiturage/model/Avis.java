package tekup.glsi.projet_covoiturage.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Avis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int note;

    private String commenter;

    @ManyToOne
    @JoinColumn(name = "idConducteur")
    Conducteur conducteur;

    @ManyToOne
    @JoinColumn(name = "idPassager")
    Passager passager;

}
