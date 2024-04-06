package ma.naji.hospital.repositories;

import ma.naji.hospital.entities.Consultation;
import ma.naji.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository <Consultation,Long>{
}
