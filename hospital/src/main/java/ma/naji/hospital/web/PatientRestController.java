package ma.naji.hospital.web;
import lombok.AllArgsConstructor;
import ma.naji.hospital.entities.Patient;
import ma.naji.hospital.repositories.PatientRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PatientRestController {

    private PatientRepo patientRepositery;
    @GetMapping("/patients")
    List<Patient> patientList(){
        return patientRepositery.findAll();
    }

}
