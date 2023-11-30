package med.voll.api.dto.doctor;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dto.address.AddressData;

public record UpdateDataDoctor(
        @NotNull Long id,
        String name,
        String phone,
        AddressData address) {

}
