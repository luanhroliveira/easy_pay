package br.com.easypay.backend.domain.adapters.services;

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
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Não foi possível salvar devido a uma falha com o banco de dados." +
                " Se o erro persistir, por favor contate o suporte!");
        }
    }
}
