package br.com.easypay.backend.domain.classes;

import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonNewDTO;
import br.com.easypay.backend.domain.classes.enums.PersonType;
import br.com.easypay.backend.infrastructure.adapters.entities.PhysicalPersonEntity;
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

    public PhysicalPerson(Long id, String name, String email, Integer active, PersonType personType, String cpf, String rg) {
        super(id, name, email, active, personType);
        this.cpf = cpf;
        this.rg = rg;
    }

    public PhysicalPerson(PhysicalPersonNewDTO physicalPersonDTO) {
        super(
            null,
            physicalPersonDTO.getName(),
            physicalPersonDTO.getEmail(),
            0,
            null
        );
        this.setCpf(physicalPersonDTO.getCpf());
        this.setRg(physicalPersonDTO.getRg());
    }

    public PhysicalPerson(PhysicalPersonEntity physicalPersonEntity) {
        super(
            physicalPersonEntity.getId(),
            physicalPersonEntity.getName(),
            physicalPersonEntity.getEmail(),
            physicalPersonEntity.getActive(),
            physicalPersonEntity.getPersonType()
        );
        this.setCpf(physicalPersonEntity.getCpf());
        this.setRg(physicalPersonEntity.getRg());
    }
}
