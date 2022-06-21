package br.com.easypay.backend.domain.classes.dtos;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalPersonDTO extends PersonDTO {

    @NotEmpty(message = MANDATORY_FILLING)
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotEmpty(message = MANDATORY_FILLING)
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
