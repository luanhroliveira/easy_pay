package br.com.easypay.backend.domain.classes.dtos;

import br.com.easypay.backend.domain.classes.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO {
    private Long id;
    private String name;
    private String email;
    private Integer active;
    private PersonType personType;
}
