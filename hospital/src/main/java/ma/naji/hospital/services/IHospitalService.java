package ma.naji.hospital.services;

import ma.naji.hospital.entities.Consultation;
import ma.naji.hospital.entities.Medecin;
import ma.naji.hospital.entities.Patient;
import ma.naji.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);

}
