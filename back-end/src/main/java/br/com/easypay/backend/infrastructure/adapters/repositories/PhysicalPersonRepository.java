package br.com.easypay.backend.infrastructure.adapters.repositories;

import br.com.easypay.backend.domain.classes.PhysicalPerson;
import br.com.easypay.backend.domain.doors.repositories.PhysicalPersonRepositoryPort;
import br.com.easypay.backend.infrastructure.adapters.entities.PhysicalPersonEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PhysicalPersonRepository implements PhysicalPersonRepositoryPort {

    private final PhysicalPersonJpaRepository physicalPersonJpaRepository;

    public PhysicalPersonRepository(PhysicalPersonJpaRepository physicalPersonJpaRepository) {
        this.physicalPersonJpaRepository = physicalPersonJpaRepository;
    }

    @Override
    public Optional<PhysicalPerson> save(PhysicalPerson physicalPerson) {
        Optional<PhysicalPersonEntity> physicalPersonEntity =
            Optional.of(physicalPersonJpaRepository.save(new PhysicalPersonEntity(physicalPerson)));
        return physicalPersonEntity.map(PhysicalPerson::new);
    }
}
