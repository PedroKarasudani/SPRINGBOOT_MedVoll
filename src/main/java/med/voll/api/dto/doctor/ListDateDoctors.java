package med.voll.api.dto.doctor;

import med.voll.api.model.Doctor;

public record ListDateDoctors(Long id, String name, String email, String crm, Specialty specialty) {

    public ListDateDoctors(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
