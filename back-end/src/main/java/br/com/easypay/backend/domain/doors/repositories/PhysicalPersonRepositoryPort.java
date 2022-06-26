package br.com.easypay.backend.domain.doors.repositories;

import br.com.easypay.backend.domain.classes.PhysicalPerson;

import java.util.Optional;

public interface PhysicalPersonRepositoryPort {

    Optional<PhysicalPerson> save(PhysicalPerson physicalPerson);

    void deleteById(Long physicalPersonId);

    PhysicalPerson findPhysicalPersonById(Long physicalPersonId);
}
