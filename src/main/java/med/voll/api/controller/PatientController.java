package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.dto.patient.DetailDataPatient;
import med.voll.api.dto.patient.RegistrationDataPatient;
import med.voll.api.model.Patient;
import med.voll.api.repository.PatientRepository;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegistrationDataPatient data, UriComponentsBuilder uriBuilder) {
        var patient = new Patient(data);
        patientRepository.save(patient);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailDataPatient(patient));
    }

}
