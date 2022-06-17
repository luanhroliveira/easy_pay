package br.com.easypay.backend.domain.classes.dtos;

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
public abstract class PersonNewDTO implements Serializable {

    final static String MANDATORY_FILLING = "Preenchimento obrigatório";

    @NotEmpty(message = MANDATORY_FILLING)
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String name;

    @NotEmpty(message = MANDATORY_FILLING)
    @Email(message = "Email inválido")
    private String email;

}
