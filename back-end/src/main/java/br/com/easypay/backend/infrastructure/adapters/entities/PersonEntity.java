package br.com.easypay.backend.infrastructure.adapters.entities;

import br.com.easypay.backend.domain.classes.enums.PersonType;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "@type")
public abstract class PersonEntity implements Serializable {

    @Id
    @GeneratedValue
    @SequenceGenerator(name = "SEQ_PERSON", sequenceName = "SEQ_PERSON")
    protected Long id;
    protected String name;
    protected String email;
    protected Integer active;
    protected PersonType personType;

}
