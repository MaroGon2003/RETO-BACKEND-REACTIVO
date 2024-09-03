package com.example.microservicio_tecnologia.infrastructure.config;

import com.example.microservicio_tecnologia.domain.api.ITechnologyServicePort;
import com.example.microservicio_tecnologia.domain.spi.ITechnologyPersistencePort;
import com.example.microservicio_tecnologia.domain.useCase.TechnologyUseCase;
import com.example.microservicio_tecnologia.infrastructure.mapper.ITechnologyEntityMapper;
import com.example.microservicio_tecnologia.infrastructure.out.adapter.TechnologyReactiveCrudAdapter;
import com.example.microservicio_tecnologia.infrastructure.out.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyReactiveCrudAdapter(technologyRepository, technologyEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort(ITechnologyPersistencePort technologyPersistencePort) {
        return new TechnologyUseCase(technologyPersistencePort);
    }

}
