package ma.naji.hospital;

import ma.naji.hospital.entities.*;
import ma.naji.hospital.repositories.ConsultationRepo;
import ma.naji.hospital.repositories.MedecinRepo;
import ma.naji.hospital.repositories.PatientRepo;
import ma.naji.hospital.repositories.RendezVousRepo;
import ma.naji.hospital.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }


    @Bean
    CommandLineRunner start(PatientRepo patientRepo,
                            MedecinRepo medecinRepo,
                            ConsultationRepo consultationRepo,
                            RendezVousRepo rendezVousRepo,
                            //injection a l aide de l interface IhospitaleServices
                            IHospitalService iHospitalService){
        return args -> {
            Stream.of("naji","alaaal","homahamad")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDateDeNaissance(new Date());
                        patient.setMalade(false);
                        //patientRepo.save(patient);
                        //utilisation de methode implementer dans hospitalServicrsImp
                        iHospitalService.savePatient(patient);

                    });
            Stream.of("elea","kea ","mia ")
                    .forEach(med->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(med);
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"dentiste");
                        medecin.setMail(med+"@gmail.com");
                        //medecinRepo.save(medecin);
                        iHospitalService.saveMedecin(medecin);
                    });

            Patient patient = patientRepo.findById(1L).orElse(null);
            Patient patient2 = patientRepo.findByNom("mohammed");
            Medecin medecin1 = medecinRepo.findByNom("kea ");
            Medecin medecin2 = medecinRepo.findById(2L).orElse(null);

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDateDeConsultation(new Date());
            rendezVous.setStatus(StatusR.PENDING);
            rendezVous.setMedecin(medecin2);
            rendezVous.setPatient(patient);
            //rendezVousRepo.save(rendezVous);
            //injection par hospitaleservice implementation de l interface ihospitale
            iHospitalService.saveRDV(rendezVous);

            RendezVous rendezVous2 = new RendezVous();
            rendezVous2.setDateDeConsultation(new Date());
            rendezVous2.setStatus(StatusR.PENDING);
            rendezVous2.setMedecin(medecin1);
            rendezVous2.setPatient(patient);
            rendezVousRepo.save(rendezVous2);


            RendezVous rendezVous3=rendezVousRepo.findById(1L).orElse(null);
            Consultation consultation1 = new Consultation();
            consultation1.setDateDeConsultation(new Date());
            consultation1.setRapport("Rapport de consul");
            consultation1.setRendezVous(rendezVous3);
            consultationRepo.save(consultation1);


            Consultation consultation = new Consultation();
            consultation.setDateDeConsultation(new Date());
            consultation.setRapport("Rapport de consul");
            consultation.setRendezVous(rendezVous2);
            //consultationRepo.save(consultation1);
            iHospitalService.saveConsultation(consultation);


        };



    }

}
