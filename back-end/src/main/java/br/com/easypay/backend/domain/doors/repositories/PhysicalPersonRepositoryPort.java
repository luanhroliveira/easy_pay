package br.com.easypay.backend.domain.doors.repositories;

import br.com.easypay.backend.domain.classes.PhysicalPerson;

public interface PhysicalPersonRepositoryPort {

    void save(PhysicalPerson physicalPerson);

}
