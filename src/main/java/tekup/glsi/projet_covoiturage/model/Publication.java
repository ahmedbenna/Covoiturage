package tekup.glsi.projet_covoiturage.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss")
    @Future(message = "To must be at a future date")
    private LocalDateTime dateDepart;
    private String lieuDepart;

    private String xD;
    private String yD;

    private String lieuArrive;

    private String xA;
    private String yA;
    @Min(value = 1, message = "To must be greater than zero")
    private int nbrePlace;
    private float prix;

    private String description;


    @ManyToOne
    @JoinColumn(name = "idConducteur")
    Conducteur conducteur;



}
