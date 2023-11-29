package med.voll.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.dto.doctor.ListDateDoctors;
import med.voll.api.dto.doctor.RegistrationDataDoctor;
import med.voll.api.repository.DoctorRepository;
import med.voll.api.model.Doctor;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegistrationDataDoctor data) {
        doctorRepository.save(new Doctor(data));

    }

    @GetMapping
    public List<ListDateDoctors> list() {
        return doctorRepository.findAll().stream().map(ListDateDoctors::new).toList();
    }
}
