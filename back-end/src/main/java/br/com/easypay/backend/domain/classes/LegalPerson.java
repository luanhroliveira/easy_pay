package br.com.easypay.backend.domain.classes;

import br.com.easypay.backend.domain.classes.dtos.LegalPersonDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
public class LegalPerson extends Person {
    private String cnpj;
    private PhysicalPerson physicalPerson;

    public LegalPerson(LegalPersonDTO legalPersonDTO) {
        super(
            legalPersonDTO.getId(),
            legalPersonDTO.getName(),
            legalPersonDTO.getEmail(),
            legalPersonDTO.getActive(),
            legalPersonDTO.getPersonType()
        );
        this.setCnpj(legalPersonDTO.getCnpj());
        this.setPhysicalPerson(new PhysicalPerson(legalPersonDTO.getPhysicalPersonDTO()));
    }
}
