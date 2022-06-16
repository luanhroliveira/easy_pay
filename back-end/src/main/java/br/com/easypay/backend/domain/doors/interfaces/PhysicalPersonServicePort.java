package br.com.easypay.backend.domain.doors.interfaces;

import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;

public interface PhysicalPersonServicePort {

    void createAPhysicalPerson(PhysicalPersonDTO physicalPersonDTO);

}
