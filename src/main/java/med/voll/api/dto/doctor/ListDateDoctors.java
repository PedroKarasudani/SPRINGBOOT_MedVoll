package med.voll.api.dto.doctor;

import med.voll.api.model.Doctor;

public record ListDateDoctors(String name, String email, String crm, Specialty specialty) {

    public ListDateDoctors(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
