package med.voll.api.dto.doctor;

import med.voll.api.model.Address;
import med.voll.api.model.Doctor;

public record DetailDataDoctor(Long id, String name, String email, String crm, String phone, Specialty specialty,
        Address address) {

    public DetailDataDoctor(Doctor doctor) {
        this(
                doctor.getId(),
                doctor.getName(),
                doctor.getEmail(),
                doctor.getCrm(),
                doctor.getPhone(),
                doctor.getSpecialty(),
                doctor.getAddress());
    }
}
