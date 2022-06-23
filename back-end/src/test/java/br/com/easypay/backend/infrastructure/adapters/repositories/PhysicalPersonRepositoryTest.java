package br.com.easypay.backend.infrastructure.adapters.repositories;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import br.com.easypay.backend.domain.classes.enums.PersonType;
import br.com.easypay.backend.infrastructure.adapters.entities.PhysicalPersonEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PhysicalPersonRepositoryTest {

    private static final Long PHYSICAL_PERSONAL_ID = 1L;

    @Mock
    private PhysicalPersonJpaRepository physicalPersonJpaRepository;

    @InjectMocks
    private PhysicalPersonRepository physicalPersonRepository;

    @Test
    void should_save_a_new_physical_person() {
        PhysicalPerson physicalPerson = this.getPhysicalPerson();

        PhysicalPersonEntity physicalPersonEntity = new PhysicalPersonEntity(physicalPerson);

        when(this.physicalPersonJpaRepository.save(any())).thenReturn(physicalPersonEntity);

        Optional<PhysicalPerson> result = this.physicalPersonRepository.save(physicalPerson);

        verify(this.physicalPersonJpaRepository).save(any());

        assertTrue(result.isPresent());
        assertEquals(PhysicalPerson.class, result.get().getClass());
        assertEquals(physicalPerson.getId(), result.get().getId());
        assertEquals(physicalPerson.getName(), result.get().getName());
        assertEquals(physicalPerson.getEmail(), result.get().getEmail());
        assertEquals(physicalPerson.getActive(), result.get().getActive());
        assertEquals(physicalPerson.getPersonType(), result.get().getPersonType());
        assertEquals(physicalPerson.getCpf(), result.get().getCpf());
        assertEquals(physicalPerson.getRg(), result.get().getRg());
    }

    @Test
    void should_delete_a_physical_person() {
        this.physicalPersonRepository.deleteById(PHYSICAL_PERSONAL_ID);
        verify(this.physicalPersonJpaRepository).deleteById(PHYSICAL_PERSONAL_ID);
    }

    private PhysicalPerson getPhysicalPerson() {
        return new PhysicalPerson(
            PHYSICAL_PERSONAL_ID,
            "Test unit",
            "test@unit.com",
            0,
            PersonType.PHYSICAL_PERSON,
            "12345678911",
            "112223334"
        );
    }
}