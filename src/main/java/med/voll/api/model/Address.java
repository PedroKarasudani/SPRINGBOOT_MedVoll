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

    public void updateData(AddressData data) {
        if (data.publicPlace() != null) {
            this.publicPlace = data.publicPlace();
        }
        if (data.publicPlace() != null) {
            this.neighborhood = data.neighborhood();
        }
        if (data.publicPlace() != null) {
            this.cep = data.cep();
        }
        if (data.publicPlace() != null) {
            this.city = data.city();
        }
        if (data.publicPlace() != null) {
            this.uf = data.uf();
        }
        if (data.publicPlace() != null) {
            this.number = data.number();
        }
        if (data.publicPlace() != null) {
            this.complement = data.complement();
        }
    }

}
