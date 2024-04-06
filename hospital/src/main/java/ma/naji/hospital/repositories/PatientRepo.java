package ma.naji.hospital.repositories;

import ma.naji.hospital.entities.Patient;
import ma.naji.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo  extends JpaRepository<Patient,Long> {
    Patient findByNom(String name);




}
