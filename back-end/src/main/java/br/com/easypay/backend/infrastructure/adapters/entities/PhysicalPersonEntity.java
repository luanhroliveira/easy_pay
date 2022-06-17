package br.com.easypay.backend.infrastructure.adapters.entities;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@JsonTypeName(value = "physicalPerson")
@DiscriminatorValue(value = "PHYSICAL_PERSON")
public final class PhysicalPersonEntity extends PersonEntity {

    @Column(name = "CPF", length = 14, unique = true)
    private String cpf;

    @Column(name = "RG", length = 11, unique = true)
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
