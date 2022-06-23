package br.com.easypay.backend.domain.adapters.services;

import br.com.easypay.backend.domain.adapters.services.exceptions.DataIntegrityException;
import br.com.easypay.backend.domain.classes.PhysicalPerson;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonDTO;
import br.com.easypay.backend.domain.classes.dtos.PhysicalPersonNewDTO;
import br.com.easypay.backend.domain.doors.interfaces.PhysicalPersonServicePort;
import br.com.easypay.backend.domain.doors.repositories.PhysicalPersonRepositoryPort;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

public class PhysicalPersonServiceImpl implements PhysicalPersonServicePort {

    private final PhysicalPersonRepositoryPort physicalPersonRepositoryPort;

    public PhysicalPersonServiceImpl(PhysicalPersonRepositoryPort physicalPersonRepositoryPort) {
        this.physicalPersonRepositoryPort = physicalPersonRepositoryPort;
    }

    @Override
    public PhysicalPersonDTO insertAPhysicalPerson(PhysicalPersonNewDTO physicalPersonNewDTO) {
        try {
            Optional<PhysicalPerson> physicalPerson =
                this.physicalPersonRepositoryPort.save(new PhysicalPerson(physicalPersonNewDTO));

            return physicalPerson.map(PhysicalPersonDTO::new).orElse(null);
        } catch (DataIntegrityException e) {
            throw new DataIntegrityException(e.getMessage());
        }
    }

    @Override
    public void deleteAPhysicalPerson(Long physicalPersonId) {
        try {
            this.physicalPersonRepositoryPort.deleteById(physicalPersonId);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException(e.getMessage());
        }
    }
}
