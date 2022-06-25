package br.com.easypay.backend.domain.doors.interfaces;

import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonNewDTO;

public interface PhysicalPersonServicePort {

    PhysicalPersonDTO insertAPhysicalPerson(PhysicalPersonNewDTO physicalPersonDTO);

    void deleteAPhysicalPerson(Long physicalPersonId);

    PhysicalPersonDTO findPhysicalPersonById(Long physicalPersonId);
}
