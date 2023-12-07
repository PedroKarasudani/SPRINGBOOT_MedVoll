package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.voll.api.dto.doctor.ListDateDoctors;
import med.voll.api.dto.doctor.RegistrationDataDoctor;
import med.voll.api.dto.doctor.UpdateDataDoctor;
import med.voll.api.dto.doctor.DetailDataDoctor;
import med.voll.api.repository.DoctorRepository;
import med.voll.api.model.Doctor;

@RestController
@RequestMapping("doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegistrationDataDoctor data, UriComponentsBuilder uriBuilder) {
        var doctor = new Doctor(data);
        doctorRepository.save(doctor);

        var uri = uriBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailDataDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<ListDateDoctors>> list(
            @PageableDefault(size = 10, sort = { "name" }) Pageable pagination) {
        var page = doctorRepository.findAllByActiveTrue(pagination).map(ListDateDoctors::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateDataDoctor data) {
        var doctor = doctorRepository.getReferenceById(data.id());
        doctor.updateData(data);

        return ResponseEntity.ok(new DetailDataDoctor(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        doctor.delete();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id) {
        var doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetailDataDoctor(doctor));
    }
}
