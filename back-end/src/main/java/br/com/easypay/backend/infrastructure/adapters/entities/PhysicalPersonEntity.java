package br.com.easypay.backend.infrastructure.adapters.entities;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@JsonTypeName(value = "physicalPerson")
public final class PhysicalPersonEntity extends PersonEntity {

    private String cpf;
    private String rg;

    public PhysicalPersonEntity(PhysicalPerson physicalPerson) {
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
