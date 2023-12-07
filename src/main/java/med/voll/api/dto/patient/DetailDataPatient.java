package med.voll.api.dto.patient;

import med.voll.api.model.Address;
import med.voll.api.model.Patient;

public record DetailDataPatient(Long id, String name, String email, String phone, String cpf, Address address) {

    public DetailDataPatient(Patient patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getCpf(),
                patient.getAddress());
    }
}
