package tekup.glsi.projet_covoiturage.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDepart;
    private String lieuDepart;
    private String lieuArrive;

    private int nbrePlace;
    private float prix;

    private String description;


    @ManyToOne
    @JoinColumn(name = "idConducteur")
    Conducteur conducteur;



}
