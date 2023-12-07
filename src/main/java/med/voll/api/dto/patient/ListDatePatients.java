package med.voll.api.dto.patient;

import med.voll.api.model.Patient;

public record ListDatePatients(String name, String email, String cpf) {

    public ListDatePatients(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
