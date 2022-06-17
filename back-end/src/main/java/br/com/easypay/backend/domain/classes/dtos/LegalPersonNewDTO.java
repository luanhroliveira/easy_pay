package br.com.easypay.backend.domain.classes.dtos;

import br.com.easypay.backend.domain.classes.LegalPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LegalPersonNewDTO extends PersonNewDTO {

    private String cnpj;
    private PhysicalPersonNewDTO physicalPersonDTO;

    public LegalPersonNewDTO(LegalPerson legalPerson) {
        super(
            legalPerson.getName(),
            legalPerson.getEmail()
        );
        this.setCnpj(legalPerson.getCnpj());
        this.setPhysicalPersonDTO(new PhysicalPersonNewDTO(legalPerson.getPhysicalPerson()));
    }
}
