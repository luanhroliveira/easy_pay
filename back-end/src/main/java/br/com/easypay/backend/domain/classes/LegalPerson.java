package br.com.easypay.backend.domain.classes;

import br.com.easypay.backend.domain.classes.dtos.LegalPersonNewDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
public final class LegalPerson extends Person {
    private String cnpj;
    private PhysicalPerson physicalPerson;

    public LegalPerson(LegalPersonNewDTO legalPersonDTO) {
        super(
            null,
            legalPersonDTO.getName(),
            legalPersonDTO.getEmail(),
            0,
            null
        );
        this.setCnpj(legalPersonDTO.getCnpj());
        this.setPhysicalPerson(new PhysicalPerson(legalPersonDTO.getPhysicalPersonDTO()));
    }
}
