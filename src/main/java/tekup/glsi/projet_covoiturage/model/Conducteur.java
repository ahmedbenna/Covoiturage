package tekup.glsi.projet_covoiturage.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Conducteur extends User{

    private String nom;

    private String prenom;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDeNaissance;

    @Column( nullable = false,unique = true)
    private Integer telephone;


    private String adresse;



    private double note;
    @JsonIgnore
    private int numbNote;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
            @JsonIgnore
    Set<Publication> publications=new HashSet<Publication>();

}
