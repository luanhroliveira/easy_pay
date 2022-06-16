package br.com.easypay.backend.domain.classes;

import br.com.easypay.backend.domain.classes.enums.PersonType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Person {
    protected Long id;
    protected String name;
    protected String email;
    protected Integer active;
    protected PersonType personType;
}
