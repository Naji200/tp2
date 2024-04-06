package ma.naji.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Collection;
import java.util.Date;
@Entity
@NoArgsConstructor @AllArgsConstructor @Data
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateDeNaissance;
    private boolean malade ;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> RendezVous;

}
