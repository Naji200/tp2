package ma.naji.hospital.repositories;

import ma.naji.hospital.entities.Medecin;
import ma.naji.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepo  extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom) ;

}
