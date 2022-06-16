package br.com.easypay.backend.infrastructure.adapters.repositories;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import br.com.easypay.backend.domain.doors.repositories.PhysicalPersonRepositoryPort;
import br.com.easypay.backend.infrastructure.adapters.entities.PhysicalPersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PhysicalPersonRepository implements PhysicalPersonRepositoryPort {

    private final PhysicalPersonJpaRepository physicalPersonJpaRepository;

    public PhysicalPersonRepository(PhysicalPersonJpaRepository physicalPersonJpaRepository) {
        this.physicalPersonJpaRepository = physicalPersonJpaRepository;
    }

    @Override
    public void save(PhysicalPerson physicalPerson) {
        PhysicalPersonEntity physicalPersonEntity = new PhysicalPersonEntity(physicalPerson);
        physicalPersonJpaRepository.save(physicalPersonEntity);
    }
}
