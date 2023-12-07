package med.voll.api.dto.patient;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.address.AddressData;

public record UpdateDataPatient(
                @NotNull Long id,
                String name,
                String phone,
                AddressData address) {

}
