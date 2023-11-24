package med.voll.api.dto.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String publicPlace;
    private String neighborhood;
    private String cep;
    private String city;
    private String uf;
    private String number;
    private String complement;

}
