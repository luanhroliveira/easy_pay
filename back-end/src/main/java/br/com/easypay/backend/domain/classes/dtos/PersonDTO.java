package br.com.easypay.backend.domain.classes.dtos;

import br.com.easypay.backend.domain.classes.enums.PersonType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class PersonDTO implements Serializable {

    static final String MANDATORY_FILLING = "Preenchimento obrigatório";

    @NotEmpty(message = MANDATORY_FILLING)
    protected Long id;

    @NotEmpty(message = MANDATORY_FILLING)
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    protected String name;

    @NotEmpty(message = MANDATORY_FILLING)
    @Email(message = "Email inválido")
    protected String email;

    @NotEmpty(message = MANDATORY_FILLING)
    protected Integer active;

    @NotEmpty(message = MANDATORY_FILLING)
    protected PersonType personType;

}
