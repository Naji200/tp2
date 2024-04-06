package ma.naji.hospital.repositories;

import ma.naji.hospital.entities.Patient;
import ma.naji.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepo  extends JpaRepository<RendezVous,Long> {
}
