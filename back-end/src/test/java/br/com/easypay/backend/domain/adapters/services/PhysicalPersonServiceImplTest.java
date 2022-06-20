package br.com.easypay.backend.domain.adapters.services;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonNewDTO;
import br.com.easypay.backend.domain.classes.enums.PersonType;
import br.com.easypay.backend.domain.doors.repositories.PhysicalPersonRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PhysicalPersonServiceImplTest {

    @Mock
    private PhysicalPersonRepositoryPort physicalPersonRepositoryPort;

    @InjectMocks
    private PhysicalPersonServiceImpl physicalPersonService;

    @Test
    public void should_save_a_physical_person() {
        PhysicalPerson physicalPerson = this.getPhysicalPerson();

        when(this.physicalPersonRepositoryPort.save(any())).thenReturn(Optional.of(physicalPerson));

        PhysicalPersonDTO result = this.physicalPersonService.insertAPhysicalPerson(new PhysicalPersonNewDTO(physicalPerson));

        verify(this.physicalPersonRepositoryPort).save(any());

        assertEquals(physicalPerson.getCpf(), result.getCpf());
        assertEquals(physicalPerson.getRg(), result.getRg());
        assertEquals(physicalPerson.getName(), result.getName());
        assertEquals(physicalPerson.getEmail(), result.getEmail());
        assertEquals(PersonType.PHYSICAL_PERSON, result.getPersonType());
    }

    @Test
    public void should_return_a_data_integrity_violation_exception_when_there_is_some_data_integrity() {
        when(this.physicalPersonRepositoryPort.save(any())).thenThrow(
            DataIntegrityViolationException.class
        );

        DataIntegrityViolationException thrown =
            assertThrows(DataIntegrityViolationException.class,
                () -> this.physicalPersonService.insertAPhysicalPerson(new PhysicalPersonNewDTO(this.getPhysicalPerson()))
            );

        assertEquals(DataIntegrityViolationException.class, thrown.getClass());
        assertEquals("Não foi possível salvar devido a uma falha com o banco de dados." +
            " Se o erro persistir, por favor contate o suporte!", thrown.getMessage());
    }

    private PhysicalPerson getPhysicalPerson() {
        return new PhysicalPerson(
            1L,
            "Test unit",
            "test@unit.com",
            0,
            PersonType.PHYSICAL_PERSON,
            "12345678911",
            "112223334"
        );
    }

}