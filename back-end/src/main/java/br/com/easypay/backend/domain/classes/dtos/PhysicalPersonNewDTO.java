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
public class PhysicalPersonNewDTO extends PersonNewDTO {

    @NotEmpty(message = PersonNewDTO.MANDATORY_FILLING)
    @CPF(message = "CPF inválido")
    private String cpf;

    @NotEmpty(message = PersonNewDTO.MANDATORY_FILLING)
    private String rg;

    public PhysicalPersonNewDTO(PhysicalPerson physicalPerson) {
        super(
            physicalPerson.getName(),
            physicalPerson.getEmail()
        );
        this.setCpf(physicalPerson.getCpf());
        this.setRg(physicalPerson.getRg());
    }

}
