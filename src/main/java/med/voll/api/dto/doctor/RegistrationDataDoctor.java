package med.voll.api.dto.doctor;

import med.voll.api.dto.address.AddressData;

public record RegistrationDataDoctor(String name, String email, String crm, Specialty specialty, AddressData address) {

}
