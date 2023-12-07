package med.voll.api.dto.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.address.AddressData;

public record RegistrationDataPatient(
                @NotBlank String name,
                @NotBlank @Email String email,
                @NotBlank String phone,
                @NotBlank String cpf,
                @NotNull @Valid AddressData address) {

}
