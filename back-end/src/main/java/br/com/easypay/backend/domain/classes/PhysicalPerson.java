package br.com.easypay.backend.domain.classes;

import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor
@AllArgsConstructor
public final class PhysicalPerson extends Person {

    private String cpf;
    private String rg;

    public PhysicalPerson(PhysicalPersonDTO physicalPersonDTO) {
        super(
            physicalPersonDTO.getId(),
            physicalPersonDTO.getName(),
            physicalPersonDTO.getEmail(),
            physicalPersonDTO.getActive(),
            physicalPersonDTO.getPersonType()
        );
        this.setCpf(physicalPersonDTO.getCpf());
        this.setRg(physicalPersonDTO.getRg());
    }
}
