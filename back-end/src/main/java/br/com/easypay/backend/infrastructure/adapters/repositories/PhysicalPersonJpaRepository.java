package br.com.easypay.backend.infrastructure.adapters.repositories;

import br.com.easypay.backend.infrastructure.adapters.entities.PhysicalPersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhysicalPersonJpaRepository extends JpaRepository<PhysicalPersonEntity, Long> {
}
