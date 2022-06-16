package br.com.easypay.backend.infrastructure.configurations;

import br.com.easypay.backend.domain.adapters.services.PhysicalPersonServiceImpl;
import br.com.easypay.backend.domain.doors.interfaces.PhysicalPersonServicePort;
import br.com.easypay.backend.domain.doors.repositories.PhysicalPersonRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    PhysicalPersonServicePort physicalPersonService(PhysicalPersonRepositoryPort physicalPersonRepositoryPort) {
        return new PhysicalPersonServiceImpl(physicalPersonRepositoryPort);
    }

}
