package med.voll.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.address.AddressData;

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

    public Address(AddressData address) {
        this.publicPlace = address.publicPlace();
        this.neighborhood = address.neighborhood();
        this.cep = address.cep();
        this.city = address.city();
        this.uf = address.uf();
        this.number = address.number();
        this.complement = address.complement();
    }

}
