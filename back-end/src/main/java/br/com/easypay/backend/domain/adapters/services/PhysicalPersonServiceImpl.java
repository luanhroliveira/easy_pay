package br.com.easypay.backend.domain.adapters.services;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;
import br.com.easypay.backend.domain.doors.interfaces.PhysicalPersonServicePort;
import br.com.easypay.backend.domain.doors.repositories.PhysicalPersonRepositoryPort;

public class PhysicalPersonServiceImpl implements PhysicalPersonServicePort {

    private final PhysicalPersonRepositoryPort physicalPersonRepositoryPort;

    public PhysicalPersonServiceImpl(PhysicalPersonRepositoryPort physicalPersonRepositoryPort) {
        this.physicalPersonRepositoryPort = physicalPersonRepositoryPort;
    }

    @Override
    public void createAPhysicalPerson(PhysicalPersonDTO physicalPersonDTO) {
        PhysicalPerson physicalPerson = new PhysicalPerson(physicalPersonDTO);
        this.physicalPersonRepositoryPort.save(physicalPerson);
    }
}
