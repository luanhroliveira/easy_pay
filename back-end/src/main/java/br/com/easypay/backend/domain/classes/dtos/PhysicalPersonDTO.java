package br.com.easypay.backend.domain.classes.dtos;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalPersonDTO extends PersonDTO {
    private String cpf;
    private String rg;



    public PhysicalPersonDTO(PhysicalPerson physicalPerson) {
        super(
            physicalPerson.getId(),
            physicalPerson.getName(),
            physicalPerson.getEmail(),
            physicalPerson.getActive(),
            physicalPerson.getPersonType()
        );
        this.setCpf(physicalPerson.getCpf());
        this.setRg(physicalPerson.getRg());
    }
}
