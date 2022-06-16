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
public class LegalPersonDTO extends PersonDTO {
    private String cnpj;
    private PhysicalPersonDTO physicalPersonDTO;

    public LegalPersonDTO(LegalPerson legalPerson) {
        super(
            legalPerson.getId(),
            legalPerson.getName(),
            legalPerson.getEmail(),
            legalPerson.getActive(),
            legalPerson.getPersonType()
        );
        this.setCnpj(legalPerson.getCnpj());
        this.setPhysicalPersonDTO(new PhysicalPersonDTO(legalPerson.getPhysicalPerson()));
    }
}
