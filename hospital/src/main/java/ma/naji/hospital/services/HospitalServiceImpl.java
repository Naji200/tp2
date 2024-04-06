package ma.naji.hospital.services;

import jakarta.transaction.Transactional;
import ma.naji.hospital.entities.Consultation;
import ma.naji.hospital.entities.Medecin;
import ma.naji.hospital.entities.Patient;
import ma.naji.hospital.entities.RendezVous;
import ma.naji.hospital.repositories.ConsultationRepo;
import ma.naji.hospital.repositories.MedecinRepo;
import ma.naji.hospital.repositories.PatientRepo;
import ma.naji.hospital.repositories.RendezVousRepo;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepo patientRepo;
    private MedecinRepo medecinRepo;
    private RendezVousRepo rendezVousRepo;
    private ConsultationRepo consultationRepo;

    public HospitalServiceImpl(PatientRepo patientRepo, MedecinRepo medecinRepo, RendezVousRepo rendezVousRepo, ConsultationRepo consultationRepo) {
        this.patientRepo = patientRepo;
        this.medecinRepo = medecinRepo;
        this.rendezVousRepo = rendezVousRepo;
        this.consultationRepo = consultationRepo;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepo.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepo.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {

        return rendezVousRepo.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepo.save(consultation);
    }
}
