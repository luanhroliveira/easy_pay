package br.com.easypay.backend.domain.adapters.services;

import br.com.easypay.backend.domain.adapters.services.exceptions.DataIntegrityException;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PhysicalPersonServiceImplTest {

    private static final Long PHYSICAL_PERSON_ID = 1L;

    @Mock
    private PhysicalPersonRepositoryPort physicalPersonRepositoryPort;

    @InjectMocks
    private PhysicalPersonServiceImpl physicalPersonService;

    @Test
    void should_save_a_physical_person() {
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
    void should_return_a_data_integrity_violation_exception_when_there_is_some_data_integrity() {
        DataIntegrityException thrown = null;

        when(this.physicalPersonRepositoryPort.save(any())).thenThrow(
            DataIntegrityViolationException.class
        );

        try {
            this.physicalPersonService.insertAPhysicalPerson(new PhysicalPersonNewDTO(this.getPhysicalPerson()));
        } catch (DataIntegrityException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertEquals(DataIntegrityException.class, thrown.getClass());
        assertEquals("Não foi possível salvar devido a uma falha com o banco de dados." +
            " Se o erro persistir, por favor contate o suporte!", thrown.getMessage());
    }

    @Test
    void should_delete_a_physical_person() {
        this.physicalPersonService.deleteAPhysicalPerson(PHYSICAL_PERSON_ID);
        verify(this.physicalPersonRepositoryPort).deleteById(PHYSICAL_PERSON_ID);
    }

    @Test
    void should_return_a_data_integrity_exception_if_any_violation_occurs_with_database() {
        doThrow(DataIntegrityViolationException.class)
            .doNothing()
            .when(this.physicalPersonRepositoryPort).deleteById(PHYSICAL_PERSON_ID);

        DataIntegrityException thrown = null;

        try {
            this.physicalPersonService.deleteAPhysicalPerson(PHYSICAL_PERSON_ID);
        } catch (DataIntegrityException e) {
            thrown = e;
        }

        assertNotNull(thrown);
        assertEquals(DataIntegrityException.class, thrown.getClass());
    }

    private PhysicalPerson getPhysicalPerson() {
        return new PhysicalPerson(
            PHYSICAL_PERSON_ID,
            "Test unit",
            "test@unit.com",
            0,
            PersonType.PHYSICAL_PERSON,
            "12345678911",
            "112223334"
        );
    }

}