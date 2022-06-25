package br.com.easypay.backend.adapters.controllers;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonNewDTO;
import br.com.easypay.backend.domain.classes.enums.PersonType;
import br.com.easypay.backend.domain.doors.interfaces.PhysicalPersonServicePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PhysicalPersonControllerTest {

    private static final Long PHYSICAL_PERSON_ID = 1L;

    @Mock
    private PhysicalPersonServicePort physicalPersonServicePort;

    @InjectMocks
    private PhysicalPersonController physicalPersonController;

    @Test
    void should_save_a_new_physical_person() {
        PhysicalPersonDTO physicalPersonDTO = new PhysicalPersonDTO(this.getPhysicalPerson());
        PhysicalPersonNewDTO physicalPersonNewDTO = new PhysicalPersonNewDTO(this.getPhysicalPerson());

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(this.physicalPersonServicePort.insertAPhysicalPerson(physicalPersonNewDTO)).thenReturn(physicalPersonDTO);

        this.physicalPersonController.insertPhysicalPerson(physicalPersonNewDTO);

        verify(this.physicalPersonServicePort).insertAPhysicalPerson(physicalPersonNewDTO);
    }

    @Test
    void should_delete_a_physical_person() {
        this.physicalPersonController.deletePhysicalPerson(PHYSICAL_PERSON_ID);

        verify(this.physicalPersonServicePort).deleteAPhysicalPerson(PHYSICAL_PERSON_ID);
    }

    @Test
    void should_return_a_physical_person() {
        PhysicalPersonDTO physicalPersonDTO = new PhysicalPersonDTO(this.getPhysicalPerson());

        when(this.physicalPersonServicePort.findPhysicalPersonById(PHYSICAL_PERSON_ID)).thenReturn(physicalPersonDTO);

        ResponseEntity<PhysicalPersonDTO> result = this.physicalPersonController.findPhysicalPersonById(PHYSICAL_PERSON_ID);

        verify(this.physicalPersonServicePort).findPhysicalPersonById(PHYSICAL_PERSON_ID);
        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        assertEquals(PhysicalPersonDTO.class, result.getBody().getClass());
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