package tekup.glsi.projet_covoiturage.model;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
public class Passager extends User {

    private String nom;

    private String prenom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeNaissance;

    @Column(name = "telephone")
    private Integer telephone;


    private String adresse;
}
